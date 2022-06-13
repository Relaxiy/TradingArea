package com.example.trading.app.domain.models.userPosts

import com.example.trading.utils.date.CurrentDate

data class UserPost(
    val userId: String,
    val images: String?,
    val title: String,
    val description: String,
    val price: String,
    val username: String,
    val email: String,
    val phoneNumber: String,
    var date: String = CurrentDate().getDate()
)
