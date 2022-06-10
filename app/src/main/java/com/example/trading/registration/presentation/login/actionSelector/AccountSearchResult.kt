package com.example.trading.registration.presentation.login.actionSelector

import com.example.trading.registration.domain.models.AccountResponse

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
