package com.example.trading.app.domain.interactors.favouritePostsInteractor

import com.example.trading.app.domain.FavouritePostsRepository
import com.example.trading.app.domain.mappers.toFavouritePost
import com.example.trading.app.domain.mappers.toFavouritePostEntity
import com.example.trading.app.domain.models.favourites.FavouritePost
import com.example.trading.app.domain.models.mainPage.Post
import javax.inject.Inject

class FavouritePostsInteractorImpl @Inject constructor(
    private val favouritePostsRepository: FavouritePostsRepository
) : FavouritePostsInteractor {

    override suspend fun getFavouritePosts(loggedUserId: String): List<FavouritePost> {
        return favouritePostsRepository.getFavouritePosts(loggedUserId).map { favouritePostEntity ->
            favouritePostEntity.toFavouritePost()
        }
    }

    override suspend fun saveFavouritePost(post: Post, loggedUserId: String) {
        favouritePostsRepository.saveFavouritePost(post.toFavouritePostEntity(loggedUserId))
    }

    override suspend fun deleteFavouritePost(id: String) {
        favouritePostsRepository.deleteFavouritePost(id)
    }
}