package com.example.cars.registration.presentation.login.resetPassword.actionSelectors

sealed class SendingCodeResult {

    data class WrongCode(
        val wrongCode: String = "Code was incorrect!"
    ) : SendingCodeResult()

    data class InvalidInputCode(
        val invalidInput: String = "Invalid input!"
    ) : SendingCodeResult()

    data class SuccessCodeResult(
        val success: String = ""
    ) : SendingCodeResult()
}