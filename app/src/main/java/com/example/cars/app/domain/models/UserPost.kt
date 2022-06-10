package com.example.cars.app.domain.models

import com.example.cars.utils.date.CurrentDate

data class UserPost(
    val userId: String,
    val images: String?,
    val title: String,
    val description: String,
    val price: String,
    val personName: String,
    val email: String,
    val phoneNumber: String,
    var date: String = CurrentDate.currentDate
)
