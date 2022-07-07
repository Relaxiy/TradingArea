package com.example.trading.app.domain.interactors.favouritePostsInteractor

import com.example.trading.app.domain.models.favourites.FavouritePost
import com.example.trading.app.domain.models.mainPage.Post

interface FavouritePostsInteractor {

    suspend fun getFavouritePosts(loggedUserId: String): List<FavouritePost>

    suspend fun saveFavouritePost(post: Post, loggedUserId: String)

    suspend fun deleteFavouritePost(id: String)
}