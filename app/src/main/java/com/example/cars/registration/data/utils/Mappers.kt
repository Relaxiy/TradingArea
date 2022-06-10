package com.example.cars.registration.data.utils

import com.example.cars.registration.data.firebase.models.AccountEntity
import com.example.cars.registration.domain.models.SignUpData

fun SignUpData.toAccountEntity() = AccountEntity(
    username = username,
    email = email,
    phoneNumber = phoneNumber,
    birthday = birthday,
    password = password
)