package com.example.trading.app.domain.mappers

import com.example.trading.app.data.firebase.userPosts.FirebaseUserPostsDatabaseManagerImpl
import com.example.trading.app.data.room.userPosts.models.UserPostEntity
import com.example.trading.app.domain.models.userPosts.UserPost
import com.example.trading.app.domain.models.userPosts.UserPostResponse
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.auth.User

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

fun List<DocumentSnapshot>.toListUserPostResponse(): List<UserPostResponse> {
    return this.map { documentSnapshot ->
        UserPostResponse(
        id = documentSnapshot.id,
        userId = documentSnapshot.get(FirebaseUserPostsDatabaseManagerImpl.KEY_USER_ID).toString(),
        images = documentSnapshot.get(FirebaseUserPostsDatabaseManagerImpl.KEY_IMAGES).toString(),
        title = documentSnapshot.get(FirebaseUserPostsDatabaseManagerImpl.KEY_TITLE).toString(),
        description = documentSnapshot.get(FirebaseUserPostsDatabaseManagerImpl.KEY_DESCRIPTION).toString(),
        price = documentSnapshot.get(FirebaseUserPostsDatabaseManagerImpl.KEY_PRICE).toString(),
        username = documentSnapshot.get(FirebaseUserPostsDatabaseManagerImpl.KEY_USERNAME).toString(),
        email = documentSnapshot.get(FirebaseUserPostsDatabaseManagerImpl.KEY_EMAIL).toString(),
        phoneNumber = documentSnapshot.get(FirebaseUserPostsDatabaseManagerImpl.KEY_PHONE_NUMBER).toString(),
        date = documentSnapshot.get(FirebaseUserPostsDatabaseManagerImpl.KEY_CREATED_AT).toString()
        )
    }
}