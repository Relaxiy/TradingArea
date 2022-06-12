package com.example.trading.app.domain

import com.example.trading.app.domain.models.mainPage.Post
import com.google.firebase.firestore.QuerySnapshot

interface PostsRepository {
    suspend fun getPosts(): QuerySnapshot?

    suspend fun savePost(post: Post)

    suspend fun deletePost(id: String)
}