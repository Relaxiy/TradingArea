package com.example.trading.app.domain

import com.example.trading.app.data.room.favouritePosts.models.FavouritePostEntity
import com.example.trading.app.domain.models.favourites.FavouritePost
import com.google.firebase.firestore.QuerySnapshot

interface FavouritePostsRepository {

    suspend fun getFavouritePosts(loggedUserId: String): List<FavouritePostEntity>

    suspend fun saveFavouritePost(favouritePostEntity: FavouritePostEntity)

    suspend fun deleteFavouritePost(id: String)
}