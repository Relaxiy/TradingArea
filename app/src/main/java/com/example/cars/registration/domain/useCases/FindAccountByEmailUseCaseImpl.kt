package com.example.cars.registration.domain.useCases

import com.example.cars.registration.domain.AccountsRepository
import com.example.cars.registration.presentation.login.resetPassword.actionSelectors.FindByPhoneNumberResult
import com.example.cars.registration.presentation.login.resetPassword.actionSelectors.FindByPhoneNumberResult.*
import javax.inject.Inject

class FindAccountByEmailUseCaseImpl @Inject constructor(
    private val accountsRepository: AccountsRepository
) : FindAccountByEmailUseCase {

    override suspend fun findAccountByPhoneNumber(phoneNumber: String): FindByPhoneNumberResult {
        return try {
            val task = accountsRepository.findAccountByEmail(phoneNumber)
            if(task != null && task.documents.size > 0){
                SuccessPhoneNumberResult(task.documents[0].id)
            } else{
                WrongPhoneNumber()
            }
        } catch (e: Exception){
            return ServerException()
        }
    }

    override suspend fun changePassword(password: String, documentPath: String) {
        accountsRepository.changePassword(password, documentPath)
    }

}