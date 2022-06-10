package com.example.cars.app.domain.mappers

import com.example.cars.app.data.room.userPosts.models.UserPostEntity
import com.example.cars.app.domain.models.UserPost
import com.example.cars.app.domain.models.UserPostResponse

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