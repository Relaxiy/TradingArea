package com.example.cars.registration.data.firebase

import com.example.cars.registration.data.firebase.models.AccountEntity
import com.example.cars.registration.domain.models.SignInData
import com.google.firebase.firestore.QuerySnapshot

interface FirebaseUsersDatabaseManager {

    suspend fun createAccount(accountEntity: AccountEntity)

    suspend fun findAccountByEmailAndPassword(signInData: SignInData): QuerySnapshot?

    suspend fun findAccountByPhoneNumber(phoneNumber: String): QuerySnapshot?

    suspend fun changePassword(password: String, documentPath: String)
}