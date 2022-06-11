package com.example.trading.app.domain.models

data class FavouritePost(
    val id: String,
    val userId: String,
    val images: String?,
    val title: String,
    val description: String,
    val price: String,
    val personName: String,
    val email: String,
    val phoneNumber: String,
    val date: String
)
