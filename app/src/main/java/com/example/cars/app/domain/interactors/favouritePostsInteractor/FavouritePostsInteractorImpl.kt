package com.example.cars.app.domain.interactors.favouritePostsInteractor

import com.example.cars.app.domain.FavouritePostsDbRepository
import com.example.cars.app.domain.mappers.toDeletedFavouritePostEntity
import com.example.cars.app.domain.mappers.toFavouritePost
import com.example.cars.app.domain.mappers.toSavedFavouritePostEntity
import com.example.cars.app.domain.models.FavouritePost
import com.example.cars.app.domain.models.Post
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