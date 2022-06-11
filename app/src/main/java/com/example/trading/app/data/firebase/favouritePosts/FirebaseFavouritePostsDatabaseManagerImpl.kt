package com.example.trading.app.data.firebase.favouritePosts

import com.example.trading.app.domain.models.FavouritePost
import com.example.trading.registration.data.utils.await
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FirebaseFavouritePostsDatabaseManagerImpl @Inject constructor() : FirebaseFavouritePostsDatabaseManager {
    companion object {
        const val KEY_COLLECTION_USERS = "users"
        const val KEY_COLLECTION_FAVOURITE_POSTS = "favourites"
        const val KEY_ID = "id"
    }

    override suspend fun getFavouritePosts(path: String): QuerySnapshot? {
        return withContext(Dispatchers.IO) {
            return@withContext FirebaseFirestore.getInstance()
                .collection(KEY_COLLECTION_USERS)
                .document(path)
                .collection(KEY_COLLECTION_FAVOURITE_POSTS)
                .get()
                .await()
        }
    }

    override suspend fun saveFavouritePost(favouritePost: FavouritePost, path: String) {
        withContext(Dispatchers.IO) {
            FirebaseFirestore.getInstance()
                .collection(KEY_COLLECTION_USERS)
                .document(path)
                .collection(KEY_COLLECTION_FAVOURITE_POSTS)
                .add(favouritePost)
                .await()
        }
    }

    override suspend fun deleteFavouritePost(id: String, path: String) {
        withContext(Dispatchers.IO) {
            val document = FirebaseFirestore.getInstance()
                .collection(KEY_COLLECTION_USERS)
                .document(path)
                .collection(KEY_COLLECTION_FAVOURITE_POSTS)
                .whereEqualTo(KEY_ID, id)
                .get()
                .await()
            FirebaseFirestore.getInstance()
                .collection(KEY_COLLECTION_USERS)
                .document(path)
                .collection(KEY_COLLECTION_FAVOURITE_POSTS)
                .document(document.documents[0].id)
                .delete()
                .await()

        }
    }


}