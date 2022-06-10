package com.example.trading.app.domain.interactors.favouritePostsInteractor

import com.example.trading.app.domain.models.FavouritePost
import com.example.trading.app.domain.models.Post

interface FavouritePostsInteractor {

    suspend fun getFavouritePosts(): List<FavouritePost>

    suspend fun saveFavouritePost(post: Post)

    suspend fun deleteFavouritePost(favouritePost: FavouritePost)
}