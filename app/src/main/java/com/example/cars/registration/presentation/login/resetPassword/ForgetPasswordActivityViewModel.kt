package com.example.cars.registration.presentation.login.resetPassword

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cars.registration.domain.useCases.FindAccountByEmailUseCase
import com.example.cars.registration.presentation.login.resetPassword.actionSelectors.ChangingPasswordResult
import com.example.cars.registration.presentation.login.resetPassword.actionSelectors.ChangingPasswordResult.*
import com.example.cars.registration.presentation.login.resetPassword.actionSelectors.FindByPhoneNumberResult
import com.example.cars.registration.presentation.login.resetPassword.actionSelectors.FindByPhoneNumberResult.*
import com.example.cars.registration.presentation.login.resetPassword.actionSelectors.SendingCodeResult
import com.example.cars.registration.presentation.login.resetPassword.actionSelectors.SendingCodeResult.*
import com.example.cars.utils.ext.isEmail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class ForgetPasswordActivityViewModel @Inject constructor(
    private val findAccountByEmailUseCase: FindAccountByEmailUseCase
) : ViewModel() {

    val searchResult: LiveData<FindByPhoneNumberResult> get() = _searchResult
    private val _searchResult = MutableLiveData<FindByPhoneNumberResult>()

    val codeResult: LiveData<SendingCodeResult> get() = _codeResult
    private val _codeResult = MutableLiveData<SendingCodeResult>()

    val passwordResult: LiveData<ChangingPasswordResult> get() = _passwordResult
    private val _passwordResult = MutableLiveData<ChangingPasswordResult>()

    fun sendEmail(phoneNumber: String) {
        viewModelScope.launch(Dispatchers.IO) {
            if (validatePhoneNumber(phoneNumber)) {
                _searchResult.postValue(findAccountByEmailUseCase.findAccountByPhoneNumber(phoneNumber))
            } else {
                _searchResult.postValue(InvalidInputPhoneNumber())
            }
        }
    }

    private fun validatePhoneNumber(phoneNumber: String): Boolean {
        return phoneNumber.isNotEmpty()
    }

    fun validateCode(sendingCode: String, userCode: String){
        when {
            sendingCode == userCode -> {
                _codeResult.value = SuccessCodeResult()
            }
            userCode.isEmpty() -> {
                _codeResult.value = InvalidInputCode()
            }
            else -> {
                _codeResult.value = WrongCode()
            }
        }
    }

    fun changePassword(changedPassword: String, documentPath: String) {
        viewModelScope.launch(Dispatchers.IO) {
            if (validatePassword(changedPassword)) {
                viewModelScope.async {
                    findAccountByEmailUseCase.changePassword(changedPassword, documentPath)
                }.await()
                _passwordResult.postValue(SuccessPasswordResult())
            } else {
                _passwordResult.postValue(InvalidInputPassword())
            }
        }
    }

    private fun validatePassword(password: String): Boolean {
        return password.isNotEmpty() ||
                password.length > 8
    }
}