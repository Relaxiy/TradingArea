package com.example.trading.registration.domain.models

data class Account(
    val username: String,
    val email: String,
    val phoneNumber: String,
    val birthday: String,
    val password: String,
    val createdAt: String,
)