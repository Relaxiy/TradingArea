package com.example.cars.registration.presentation.login.actionSelector

import com.example.cars.registration.data.firebase.models.AccountEntity
import com.example.cars.registration.domain.models.Account
import com.example.cars.registration.domain.models.AccountResponse

sealed class AccountSearchResult{

    data class WrongResult(
        val error: String = "Email or password was incorrect!"
    ) : AccountSearchResult()

    data class InvalidInput(
        val invalidInput: String = "Invalid input!"
    ) : AccountSearchResult()

    data class SuccessResult(
        val accountResponse: AccountResponse
    ) : AccountSearchResult()

}
