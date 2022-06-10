package com.example.cars.registration.presentation.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cars.registration.domain.interactor.AccountsInteractor
import com.example.cars.registration.domain.models.SignUpData
import com.example.cars.registration.presentation.register.actionSelector.RegistrationActionSelector
import com.example.cars.registration.presentation.register.actionSelector.RegistrationActionSelector.*
import com.example.cars.utils.ext.isEmail
import com.example.cars.utils.ext.toLiteVersionPhoneNumber
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class RegisterActivityViewModel @Inject constructor(private val accountsInteractor: AccountsInteractor) :
    ViewModel() {

    val result: LiveData<RegistrationActionSelector> get() = _result
    private val _result = MutableLiveData<RegistrationActionSelector>()

    fun saveAccount(
        username: String,
        email: String,
        phoneNumber: String,
        birthday: String,
        password: String,
        repeatPassword: String
    ) {
        val account = createAccount(username, email, phoneNumber, birthday, password, repeatPassword)
        if (validate(account)) {
            viewModelScope.launch {
                _result.value = viewModelScope.async {
                    try {
                        accountsInteractor.createAccount(account)
                        return@async OpenMainActivity
                    } catch (e: Exception) {
                        return@async ShowExistingEmailDialog()
                    }
                }.await()
            }
        } else {
            _result.value = ShowInvalidInputDialog()
        }
    }

    private fun createAccount(
        username: String,
        email: String,
        phoneNumber: String,
        birthday: String,
        password: String,
        repeatPassword: String
    ): SignUpData {
        return SignUpData(
            username = username,
            email = email,
            phoneNumber = phoneNumber,
            birthday = birthday,
            password = password,
            repeatPassword = repeatPassword
        )
    }

    private fun validate(signUpData: SignUpData): Boolean {
        signUpData.apply {
            return username.isNotEmpty() ||
                    email.isNotEmpty() ||
                    email.isEmail() ||
                    birthday.isNotEmpty() ||
                    password.isNotEmpty() ||
                    repeatPassword.isNotEmpty() ||
                    password == signUpData.repeatPassword ||
                    password.length == 8
        }
    }

}