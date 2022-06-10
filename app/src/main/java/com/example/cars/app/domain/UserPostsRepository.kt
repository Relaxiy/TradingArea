package com.example.cars.app.domain

import com.example.cars.app.data.room.userPosts.models.UserPostEntity
import com.example.cars.app.domain.models.UserPost
import com.example.cars.app.domain.models.UserPostResponse
import com.google.firebase.firestore.QuerySnapshot

interface UserPostsRepository {

    suspend fun getUserPosts(): List<UserPostEntity>
    suspend fun getUserPostsFromFirebase(documentPath: String): QuerySnapshot?

    suspend fun saveUserPost(userPostEntity: UserPostEntity)

    suspend fun deleteUserPost(userPostEntity: UserPostEntity)

    suspend fun saveUserPostInFirestore(userPost: UserPost): String

    suspend fun deleteUserPostInFirestore(userPostResponse: UserPostResponse)
}