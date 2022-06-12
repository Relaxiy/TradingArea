package com.example.trading.app.data.repositories

import com.example.trading.app.data.firebase.posts.FirebasePostsDatabaseManager
import com.example.trading.app.domain.PostsRepository
import com.example.trading.app.domain.models.mainPage.Post
import com.google.firebase.firestore.QuerySnapshot
import javax.inject.Inject

class PostsRepositoryImpl @Inject constructor(
    private val firebasePostsDatabaseManager: FirebasePostsDatabaseManager
) : PostsRepository {

    override suspend fun getPosts(): QuerySnapshot? {
        return firebasePostsDatabaseManager.getPosts()
    }

    override suspend fun savePost(post: Post) {
        firebasePostsDatabaseManager.savePost(post)
    }

    override suspend fun deletePost(id: String) {
        firebasePostsDatabaseManager.deletePost(id)
    }
}