package com.example.trading.app.domain.interactors.userPostsInteractor

import com.example.trading.app.domain.models.UserPost
import com.example.trading.app.domain.models.UserPostResponse
import com.example.trading.app.presentation.userPosts.actionSelector.GetPostsResult

interface UserPostsInteractor {

    suspend fun getUserPosts(): List<UserPostResponse>
    suspend fun getUserPostsFromFirebase(documentPath: String): GetPostsResult

    suspend fun saveUserPostInRoom(userPostResponse: UserPostResponse)

    suspend fun deleteUserPostInRoom(userPostResponse: UserPostResponse)

    suspend fun saveUserPostInFirestore(userPost: UserPost): UserPostResponse

    suspend fun deleteUserPostInFirestore(userPostResponse: UserPostResponse)
}