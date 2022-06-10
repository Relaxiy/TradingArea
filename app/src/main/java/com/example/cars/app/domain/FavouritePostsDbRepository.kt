package com.example.cars.app.domain

import com.example.cars.app.data.room.favouritePosts.models.FavouritePostEntity

interface FavouritePostsDbRepository {

    suspend fun getFavouritePosts(): List<FavouritePostEntity>

    suspend fun saveFavouritePost(favouritePostEntity: FavouritePostEntity)

    suspend fun deleteFavouritePost(favouritePostEntity: FavouritePostEntity)
}