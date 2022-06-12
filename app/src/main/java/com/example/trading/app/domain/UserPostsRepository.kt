package com.example.trading.app.domain

import com.example.trading.app.data.room.userPosts.models.UserPostEntity
import com.example.trading.app.domain.models.userPosts.UserPost
import com.example.trading.app.domain.models.userPosts.UserPostResponse
import com.google.firebase.firestore.QuerySnapshot

interface UserPostsRepository {

    suspend fun getUserPosts(userId: String): List<UserPostEntity>

    suspend fun getUserPostsFromFirebase(documentPath: String): QuerySnapshot?

    suspend fun saveUserPost(userPostEntity: UserPostEntity)

    suspend fun deleteUserPost(id: String)

    suspend fun saveUserPostInFirestore(userPost: UserPost): String

    suspend fun deleteUserPostInFirestore(userPostResponse: UserPostResponse)
}