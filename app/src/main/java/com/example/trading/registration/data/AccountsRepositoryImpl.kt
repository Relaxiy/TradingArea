package com.example.trading.registration.data

import com.example.trading.registration.data.firebase.FirebaseUsersDatabaseManager
import com.example.trading.registration.data.utils.toAccountEntity
import com.example.trading.registration.domain.AccountsRepository
import com.example.trading.registration.domain.models.SignInData
import com.example.trading.registration.domain.models.SignUpData
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AccountsRepositoryImpl @Inject constructor(
    private val firebaseUsersDatabaseManager: FirebaseUsersDatabaseManager
) : AccountsRepository {

    override suspend fun findAccountByEmailAndPassword(signInData: SignInData): QuerySnapshot? {
        return firebaseUsersDatabaseManager.findAccountByEmailAndPassword(signInData)
    }

    override suspend fun findAccountByEmail(phoneNumber: String): QuerySnapshot? {
        return firebaseUsersDatabaseManager.findAccountByPhoneNumber(phoneNumber)
    }

    override suspend fun createAccount(signUpData: SignUpData) {
        withContext(Dispatchers.IO) {
            firebaseUsersDatabaseManager.createAccount(signUpData.toAccountEntity())
        }
    }

    override suspend fun changePassword(password: String, documentPath: String) {
        firebaseUsersDatabaseManager.changePassword(password, documentPath)
    }
}