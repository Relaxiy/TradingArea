package com.example.cars.app.domain.interactors.userPostsInteractor

import com.example.cars.app.domain.models.UserPost
import com.example.cars.app.domain.models.UserPostResponse
import com.example.cars.app.presentation.addPost.actionSelector.CreateUserPostResult
import com.example.cars.app.presentation.userPosts.actionSelector.GetPostsResult

interface UserPostsInteractor {

    suspend fun getUserPosts(): List<UserPostResponse>
    suspend fun getUserPostsFromFirebase(documentPath: String): GetPostsResult

    suspend fun saveUserPostInRoom(userPostResponse: UserPostResponse)

    suspend fun deleteUserPostInRoom(userPostResponse: UserPostResponse)

    suspend fun saveUserPostInFirestore(userPost: UserPost): UserPostResponse

    suspend fun deleteUserPostInFirestore(userPostResponse: UserPostResponse)
}