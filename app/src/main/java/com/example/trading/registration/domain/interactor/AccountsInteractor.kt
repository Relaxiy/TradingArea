package com.example.trading.registration.domain.interactor

import com.example.trading.registration.domain.models.SignInData
import com.example.trading.registration.domain.models.SignUpData
import com.example.trading.registration.presentation.login.actionSelector.AccountSearchResult

interface AccountsInteractor {

    suspend fun findAccountIdByEmailAndPassword(signInData: SignInData): AccountSearchResult

    suspend fun createAccount(signUpData: SignUpData)

}