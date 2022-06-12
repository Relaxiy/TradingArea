package com.example.trading.app.domain.interactors.userPostsInteractor

import com.example.trading.app.domain.models.userPosts.UserPost
import com.example.trading.app.domain.models.userPosts.UserPostResponse
import com.example.trading.app.presentation.userPosts.actionSelector.GetPostsResult

interface UserPostsInteractor {

    suspend fun getUserPosts(userId: String): List<UserPostResponse>

    suspend fun getUserPostsFromFirebase(documentPath: String): GetPostsResult

    suspend fun saveUserPostInRoom(userPostResponse: UserPostResponse)

    suspend fun deleteUserPostInRoom(id: String)

    suspend fun saveUserPostInFirestore(userPost: UserPost): UserPostResponse

    suspend fun deleteUserPostInFirestore(userPostResponse: UserPostResponse)
}