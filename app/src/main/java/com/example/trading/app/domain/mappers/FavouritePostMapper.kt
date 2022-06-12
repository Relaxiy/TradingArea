package com.example.trading.app.domain.mappers

import com.example.trading.app.domain.models.favourites.FavouritePost
import com.example.trading.app.domain.models.mainPage.Post

fun Post.toFavouritePost() = FavouritePost(
    id = id,
    userId = userId,
    images = images,
    title = title,
    description = description,
    price = price,
    username = username,
    email = email,
    phoneNumber = phoneNumber,
    date = date
)