package com.example.trading.registration.domain

import com.example.trading.registration.domain.models.SignInData
import com.example.trading.registration.domain.models.SignUpData
import com.google.firebase.firestore.QuerySnapshot

interface AccountsRepository {

    suspend fun findAccountByEmailAndPassword(signInData: SignInData): QuerySnapshot?

    suspend fun findAccountByEmail(phoneNumber: String): QuerySnapshot?

    suspend fun createAccount(signUpData: SignUpData)

    suspend fun changePassword(password: String, documentPath: String)
}