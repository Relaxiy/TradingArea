package com.example.cars.app.data.firebase

import com.example.cars.app.domain.models.UserPost
import com.example.cars.app.domain.models.UserPostResponse
import com.example.cars.registration.data.firebase.FirebaseUsersDatabaseManagerImpl
import com.example.cars.registration.data.utils.await
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FirebasePostsDatabaseManagerImpl @Inject constructor() : FirebasePostsDatabaseManager {
    companion object {
        const val KEY_COLLECTION_USERS = "users"
        const val KEY_COLLECTION_USER_POSTS = "userPosts"
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

    override suspend fun getUserPosts(documentPath: String): QuerySnapshot? {
         return withContext(Dispatchers.IO) {
             return@withContext FirebaseFirestore.getInstance()
                 .collection(FirebaseUsersDatabaseManagerImpl.KEY_COLLECTION_USERS)
                 .document(documentPath)
                 .collection(KEY_COLLECTION_USER_POSTS)
                 .get()
                 .await()
         }
    }

    override suspend fun saveUserPost(userPost: UserPost) : String {
        return withContext(Dispatchers.IO) {
            val document = FirebaseFirestore.getInstance()
                .collection(FirebaseUsersDatabaseManagerImpl.KEY_COLLECTION_USERS).document(userPost.userId)
                .collection(KEY_COLLECTION_USER_POSTS)
                .add(userPost)
                .await()
            return@withContext document.id
        }
    }

    override suspend fun deleteUserPost(userPostResponse: UserPostResponse) {
        withContext(Dispatchers.IO) {
            FirebaseFirestore.getInstance()
                .collection(FirebaseUsersDatabaseManagerImpl.KEY_COLLECTION_USERS).document(userPostResponse.userId)
                .collection(KEY_COLLECTION_USER_POSTS)
                .document(userPostResponse.id)
                .delete()
                .await()
        }
    }
}