package com.example.cars.registration.domain.useCases

import com.example.cars.registration.presentation.login.resetPassword.actionSelectors.FindByPhoneNumberResult

interface FindAccountByEmailUseCase {
    suspend fun findAccountByPhoneNumber(phoneNumber: String): FindByPhoneNumberResult

    suspend fun changePassword(password: String, documentPath: String)
}