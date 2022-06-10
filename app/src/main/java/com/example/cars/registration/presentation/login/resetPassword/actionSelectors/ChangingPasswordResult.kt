package com.example.cars.registration.presentation.login.resetPassword.actionSelectors

sealed class ChangingPasswordResult {

    data class SuccessPasswordResult(
        val success: String = "Success password changing"
    ) : ChangingPasswordResult()

    data class InvalidInputPassword(
        val invalidInput: String = "Invalid input!"
    ) : ChangingPasswordResult()
}