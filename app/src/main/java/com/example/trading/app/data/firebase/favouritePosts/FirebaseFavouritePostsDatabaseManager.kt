package com.example.trading.app.data.firebase.favouritePosts

import com.example.trading.app.domain.models.favourites.FavouritePost
import com.google.firebase.firestore.QuerySnapshot

interface FirebaseFavouritePostsDatabaseManager {

    suspend fun getFavouritePosts(path: String): QuerySnapshot?

    suspend fun saveFavouritePost(favouritePost: FavouritePost, path: String)

    suspend fun deleteFavouritePost(id: String, path: String)

}