package com.example.trading.app.data.firebase

import com.example.trading.app.domain.models.UserPost
import com.example.trading.app.domain.models.UserPostResponse
import com.google.firebase.firestore.QuerySnapshot

interface FirebasePostsDatabaseManager {

    suspend fun getUserPosts(documentPath: String): QuerySnapshot?

    suspend fun saveUserPost(userPost: UserPost) : String

    suspend fun deleteUserPost(userPostResponse: UserPostResponse)

}