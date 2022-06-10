package com.example.cars.registration.domain.interactor

import com.example.cars.registration.data.firebase.FirebaseUsersDatabaseManagerImpl
import com.example.cars.registration.domain.AccountsRepository
import com.example.cars.registration.domain.models.AccountResponse
import com.example.cars.registration.domain.models.SignUpData
import com.example.cars.registration.domain.models.SignInData
import com.example.cars.registration.presentation.login.actionSelector.AccountSearchResult
import javax.inject.Inject

class AccountsInteractorImpl @Inject constructor(
    private val accountsRepository: AccountsRepository
) : AccountsInteractor {

    override suspend fun findAccountIdByEmailAndPassword(signInData: SignInData): AccountSearchResult {
        return try {
            val task = accountsRepository.findAccountByEmailAndPassword(signInData)
            if (task != null && task.documents.size > 0) {
                val documentSnapshot = task.documents[0]
                AccountSearchResult.SuccessResult(
                    AccountResponse(
                        id = documentSnapshot.id,
                        username = documentSnapshot.get(FirebaseUsersDatabaseManagerImpl.KEY_USERNAME)
                            .toString(),
                        email = documentSnapshot.get(FirebaseUsersDatabaseManagerImpl.KEY_EMAIL)
                            .toString(),
                        phoneNumber = documentSnapshot.get(FirebaseUsersDatabaseManagerImpl.KEY_PHONE_NUMBER)
                            .toString(),
                        password = documentSnapshot.get(FirebaseUsersDatabaseManagerImpl.KEY_PASSWORD)
                            .toString(),
                        birthday = documentSnapshot.get(FirebaseUsersDatabaseManagerImpl.KEY_BIRTHDAY)
                            .toString(),
                        createdAt = documentSnapshot.get(FirebaseUsersDatabaseManagerImpl.KEY_CREATED_AT)
                            .toString()
                    )
                )
            } else {
                AccountSearchResult.WrongResult()
            }
        } catch (e: Exception){
            return AccountSearchResult.WrongResult()
        }
    }

    override suspend fun createAccount(signUpData: SignUpData) {
        accountsRepository.createAccount(signUpData)
    }

}