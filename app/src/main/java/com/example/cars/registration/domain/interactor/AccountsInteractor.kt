package com.example.cars.registration.domain.interactor

import com.example.cars.registration.domain.models.SignInData
import com.example.cars.registration.domain.models.SignUpData
import com.example.cars.registration.presentation.login.actionSelector.AccountSearchResult

interface AccountsInteractor {

    suspend fun findAccountIdByEmailAndPassword(signInData: SignInData): AccountSearchResult

    suspend fun createAccount(signUpData: SignUpData)

}