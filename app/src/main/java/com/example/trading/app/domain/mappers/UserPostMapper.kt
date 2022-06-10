package com.example.trading.app.domain.mappers

import com.example.trading.app.data.room.userPosts.models.UserPostEntity
import com.example.trading.app.domain.models.UserPostResponse

fun UserPostResponse.toUserPostEntity() = UserPostEntity(
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

fun UserPostEntity.toUserPostResponse() = UserPostResponse(
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