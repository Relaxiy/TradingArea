package com.example.trading.app.domain.models.favourites

data class FavouritePost(
    val id: String,
    val loggedUserId: String,
    val images: String?,
    val title: String,
    val price: String,
    val date: String
)
