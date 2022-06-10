package com.example.trading.registration.data.utils

import com.example.trading.registration.data.firebase.models.AccountEntity
import com.example.trading.registration.domain.models.SignUpData

fun SignUpData.toAccountEntity() = AccountEntity(
    username = username,
    email = email,
    phoneNumber = phoneNumber,
    birthday = birthday,
    password = password
)