package com.example.trading.app.domain.mappers

import com.example.trading.app.data.room.favouritePosts.models.FavouritePostEntity
import com.example.trading.app.domain.models.Post

fun Post.toSavedFavouritePostEntity() = FavouritePostEntity(
    images = images,
    title = title,
    description = description,
    price = price,
    personName = personName,
    email = email,
    phoneNumber = phoneNumber,
    date = date
)