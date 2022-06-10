package com.example.cars.app.domain.mappers

import com.example.cars.app.data.room.favouritePosts.models.FavouritePostEntity
import com.example.cars.app.domain.models.Post

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