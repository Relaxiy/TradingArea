package com.example.trading.app.domain.mappers

import com.example.trading.app.domain.models.Post
import com.example.trading.app.domain.models.UserPostResponse

fun UserPostResponse.toPost() = Post(
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
