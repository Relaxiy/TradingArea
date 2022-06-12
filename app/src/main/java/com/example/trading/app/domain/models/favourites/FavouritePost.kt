package com.example.trading.app.domain.models.favourites

data class FavouritePost(
    val id: String,
    val userId: String,
    val images: String?,
    val title: String,
    val description: String,
    val price: String,
    val username: String,
    val email: String,
    val phoneNumber: String,
    val date: String
)
