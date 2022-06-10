package com.example.cars.registration.presentation.login.resetPassword.actionSelectors

sealed class FindByPhoneNumberResult {
    data class WrongPhoneNumber(
        val wrongEmail: String = "Phone number was incorrect!"
    ) : FindByPhoneNumberResult()

    data class InvalidInputPhoneNumber(
        val invalidInput: String = "Invalid input!"
    ) : FindByPhoneNumberResult()

    data class ServerException(
        val serverError: String = "Server exception"
    ) : FindByPhoneNumberResult()

    data class SuccessPhoneNumberResult(
        val userId: String
    ) : FindByPhoneNumberResult()
}