package com.example.trading.app.domain.interactors.favouritePostsInteractor

import com.example.trading.app.domain.models.FavouritePost
import com.example.trading.app.domain.models.Post

interface FavouritePostsInteractor {

    suspend fun getFavouritePosts(path: String): List<FavouritePost>

    suspend fun saveFavouritePost(post: Post, path: String)

    suspend fun deleteFavouritePost(id: String, path: String)
}