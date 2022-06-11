package com.example.trading.app.data.firebase.posts

import com.example.trading.app.domain.models.Post
import com.example.trading.registration.data.utils.await
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FirebasePostsDatabaseManagerImpl @Inject constructor() : FirebasePostsDatabaseManager {
    companion object {
        const val KEY_COLLECTION_POSTS = "posts"
        const val KEY_ID = "id"
        const val KEY_USER_ID = "userId"
        const val KEY_IMAGES = "images"
        const val KEY_TITLE = "title"
        const val KEY_DESCRIPTION = "description"
        const val KEY_PRICE = "price"
        const val KEY_USERNAME = "username"
        const val KEY_EMAIL = "email"
        const val KEY_PHONE_NUMBER = "phoneNumber"
        const val KEY_CREATED_AT = "date"
    }

    override suspend fun getPosts(): QuerySnapshot? {
        return withContext(Dispatchers.IO) {
            return@withContext FirebaseFirestore.getInstance()
                .collection(KEY_COLLECTION_POSTS)
                .get()
                .await()
        }
    }

    override suspend fun savePost(post: Post) {
         withContext(Dispatchers.IO) {
              FirebaseFirestore.getInstance()
                .collection(KEY_COLLECTION_POSTS)
                .add(post)
                .await()
        }
    }

    override suspend fun deletePost(id: String) {
        withContext(Dispatchers.IO) {
            val document = FirebaseFirestore.getInstance()
                .collection(KEY_COLLECTION_POSTS)
                .whereEqualTo(KEY_ID, id)
                .get()
                .await()

            FirebaseFirestore.getInstance()
                .collection(KEY_COLLECTION_POSTS)
                .document(document.documents[0].id)
                .delete()
                .await()
        }
    }
}