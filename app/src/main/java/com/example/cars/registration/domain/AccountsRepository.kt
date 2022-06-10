package com.example.cars.registration.domain

import com.example.cars.registration.domain.models.SignInData
import com.example.cars.registration.domain.models.SignUpData
import com.google.firebase.firestore.QuerySnapshot

interface AccountsRepository {

    suspend fun findAccountByEmailAndPassword(signInData: SignInData): QuerySnapshot?

    suspend fun findAccountByEmail(email: String): QuerySnapshot?

    suspend fun createAccount(signUpData: SignUpData)

    suspend fun changePassword(password: String, documentPath: String)
}