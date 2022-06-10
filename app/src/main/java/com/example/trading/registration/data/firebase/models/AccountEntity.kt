package com.example.trading.registration.data.firebase.models

import com.example.trading.utils.date.CurrentDate

data class AccountEntity(
    val username: String,
    val email: String,
    val phoneNumber: String,
    val birthday: String,
    val password: String,
    val createdAt: String = CurrentDate.currentDate
)