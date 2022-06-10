package com.example.cars.app.domain.models

data class UserPostResponse(
    val id: String,
    val userId: String,
    val images: String?,
    val title: String,
    val description: String,
    val price: String,
    val personName: String,
    val email: String,
    val phoneNumber: String,
    var date: String
)