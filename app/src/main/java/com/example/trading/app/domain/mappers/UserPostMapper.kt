package com.example.trading.app.domain.mappers

import com.example.trading.app.data.room.userPosts.models.UserPostEntity
import com.example.trading.app.domain.models.userPosts.UserPost
import com.example.trading.app.domain.models.userPosts.UserPostResponse

fun UserPostResponse.toUserPostEntity() = UserPostEntity(
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

fun UserPostEntity.toUserPostResponse() = UserPostResponse(
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

fun UserPost.toUserPostResponse(id: String) = UserPostResponse(
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