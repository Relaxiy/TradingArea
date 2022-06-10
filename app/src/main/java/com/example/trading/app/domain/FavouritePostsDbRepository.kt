package com.example.trading.app.domain

import com.example.trading.app.data.room.favouritePosts.models.FavouritePostEntity

interface FavouritePostsDbRepository {

    suspend fun getFavouritePosts(): List<FavouritePostEntity>

    suspend fun saveFavouritePost(favouritePostEntity: FavouritePostEntity)

    suspend fun deleteFavouritePost(favouritePostEntity: FavouritePostEntity)
}