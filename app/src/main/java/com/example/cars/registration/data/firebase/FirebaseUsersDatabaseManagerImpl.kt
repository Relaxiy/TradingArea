package com.example.cars.registration.data.firebase

import com.example.cars.registration.data.firebase.models.AccountEntity
import com.example.cars.registration.data.utils.await
import com.example.cars.registration.domain.models.SignInData
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FirebaseUsersDatabaseManagerImpl @Inject constructor() : FirebaseUsersDatabaseManager {
    companion object {
        const val KEY_COLLECTION_USERS = "users"
        const val KEY_EMAIL = "email"
        const val KEY_PASSWORD = "password"
        const val KEY_BIRTHDAY = "birthday"
        const val KEY_USERNAME = "username"
        const val KEY_ID = "id"
        const val KEY_CREATED_AT = "createdAt"
        const val KEY_PHONE_NUMBER = "phoneNumber"
    }

    override suspend fun createAccount(accountEntity: AccountEntity) {
        FirebaseFirestore.getInstance().collection(KEY_COLLECTION_USERS).add(accountEntity)
    }

    override suspend fun findAccountByEmailAndPassword(signInData: SignInData): QuerySnapshot? =
        withContext(Dispatchers.IO) {
            return@withContext FirebaseFirestore.getInstance().collection(KEY_COLLECTION_USERS)
                .whereEqualTo(KEY_EMAIL, signInData.email)
                .whereEqualTo(KEY_PASSWORD, signInData.password)
                .get()
                .await()
        }

    override suspend fun findAccountByPhoneNumber(phoneNumber: String): QuerySnapshot? =
        withContext(Dispatchers.IO) {
            return@withContext FirebaseFirestore.getInstance().collection(KEY_COLLECTION_USERS)
                .whereEqualTo(KEY_PHONE_NUMBER, phoneNumber)
                .get()
                .await()
        }

    override suspend fun changePassword(password: String, documentPath: String) {
        withContext(Dispatchers.IO) {
            return@withContext FirebaseFirestore.getInstance().collection(KEY_COLLECTION_USERS)
                .document(documentPath)
                .update(KEY_PASSWORD, password)
                .await()
        }
    }
}