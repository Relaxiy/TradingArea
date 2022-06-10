package com.example.cars.registration.presentation.login


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cars.registration.domain.interactor.AccountsInteractor
import com.example.cars.registration.domain.models.Account
import com.example.cars.registration.domain.models.AccountResponse
import com.example.cars.registration.domain.models.SignInData
import com.example.cars.registration.presentation.login.actionSelector.AccountSearchResult
import com.example.cars.registration.presentation.login.actionSelector.AccountSearchResult.*
import com.example.cars.utils.ext.isEmail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginActivityViewModel @Inject constructor(
    private val accountsInteractor: AccountsInteractor
) : ViewModel() {

    val searchResult: LiveData<AccountSearchResult> get() = _searchResult
    private val _searchResult = MutableLiveData<AccountSearchResult>()

    val account: LiveData<AccountResponse> get() = _account
    private val _account = MutableLiveData<AccountResponse>()

    fun signIn(email: String, password: String) {
        val signInData = createSignInAccount(email, password)
        if (!validateSignIn(signInData)) {
            viewModelScope.launch(Dispatchers.IO) {
                _searchResult.postValue(
                    viewModelScope.async {
                        accountsInteractor.findAccountIdByEmailAndPassword(
                            signInData
                        )
                    }.await()
                )
                when (searchResult.value) {
                    is SuccessResult -> {
                        _account.postValue((searchResult.value as SuccessResult).accountResponse)
                    }
                }
            }
        } else {
            _searchResult.value = InvalidInput()
        }
    }

    private fun validateSignIn(signInData: SignInData): Boolean {
        signInData.apply {
            return email.isEmpty() ||
                    password.isEmpty() ||
                    !email.isEmail() ||
                    password.length != 8
        }
    }

    private fun createSignInAccount(email: String, password: String): SignInData {
        return SignInData(
            email = email,
            password = password
        )
    }

}