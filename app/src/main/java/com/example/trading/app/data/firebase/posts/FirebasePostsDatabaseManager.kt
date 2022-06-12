package com.example.trading.app.data.firebase.posts

import com.example.trading.app.domain.models.mainPage.Post
import com.google.firebase.firestore.QuerySnapshot

interface FirebasePostsDatabaseManager {

    suspend fun getPosts(): QuerySnapshot?

    suspend fun savePost(post: Post)

    suspend fun deletePost(id: String)

}