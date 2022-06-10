package com.example.trading.registration.domain.models

data class SignUpData(
    val username: String,
    val email: String,
    val phoneNumber: String,
    val birthday: String,
    val password: String,
    val repeatPassword: String
)