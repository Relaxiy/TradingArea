package com.example.trading.app.domain.mappers

import com.example.trading.app.domain.models.FavouritePost
import com.example.trading.app.domain.models.Post

fun Post.toFavouritePost() = FavouritePost(
    id = id,
    userId = userId,
    images = images,
    title = title,
    description = description,
    price = price,
    personName = personName,
    email = email,
    phoneNumber = phoneNumber,
    date = date
)