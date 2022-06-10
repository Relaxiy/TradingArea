package com.example.cars.app.presentation.personalPage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cars.registration.domain.models.Account
import com.example.cars.registration.domain.models.AccountResponse

class UserSharedViewModel : ViewModel() {

    val account: LiveData<AccountResponse> get() = _account
    private val _account = MutableLiveData<AccountResponse>()

    fun shareAccountIntoPersonalPage(
        id: String,
        username: String,
        email: String,
        phoneNumber: String,
        birthday: String,
        password: String,
        createdAt: String
    ) {
        _account.value = AccountResponse(
            id = id,
            username = username,
            email = email,
            phoneNumber = phoneNumber,
            birthday = birthday,
            password = password,
            createdAt = createdAt
        )
    }
}