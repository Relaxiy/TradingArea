package com.example.cars.registration.domain.models

data class AccountResponse(
    val id: String,
    val username: String,
    val email: String,
    val phoneNumber: String,
    val birthday: String,
    val password: String,
    val createdAt: String,
)
