package com.example.trading.app.domain.interactors.favouritePostsInteractor

import com.example.trading.app.domain.FavouritePostsDbRepository
import com.example.trading.app.domain.mappers.toDeletedFavouritePostEntity
import com.example.trading.app.domain.mappers.toFavouritePost
import com.example.trading.app.domain.mappers.toSavedFavouritePostEntity
import com.example.trading.app.domain.models.FavouritePost
import com.example.trading.app.domain.models.Post
import javax.inject.Inject

class FavouritePostsInteractorImpl @Inject constructor(
    private val favouritePostsDbRepository: FavouritePostsDbRepository
) : FavouritePostsInteractor {
    override suspend fun getFavouritePosts(): List<FavouritePost> {
        return favouritePostsDbRepository.getFavouritePosts().map { favouritePostEntity ->
            favouritePostEntity.toFavouritePost()
        }
    }

    override suspend fun saveFavouritePost(post: Post) {
        favouritePostsDbRepository.saveFavouritePost(
            favouritePostEntity = post.toSavedFavouritePostEntity()
        )
    }

    override suspend fun deleteFavouritePost(favouritePost: FavouritePost) {
        favouritePostsDbRepository.deleteFavouritePost(
            favouritePostEntity = favouritePost.toDeletedFavouritePostEntity()
        )
    }
}