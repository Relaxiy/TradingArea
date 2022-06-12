package com.example.trading.app.domain.interactors.favouritePostsInteractor

import com.example.trading.app.data.firebase.posts.FirebasePostsDatabaseManagerImpl
import com.example.trading.app.domain.FavouritePostsRepository
import com.example.trading.app.domain.mappers.toFavouritePost
import com.example.trading.app.domain.models.favourites.FavouritePost
import com.example.trading.app.domain.models.mainPage.Post
import javax.inject.Inject

class FavouritePostsInteractorImpl @Inject constructor(
    private val favouritePostsRepository: FavouritePostsRepository
) : FavouritePostsInteractor {

    override suspend fun getFavouritePosts(path: String): List<FavouritePost> {
        val postsList = favouritePostsRepository.getFavouritePosts(path)
        return postsList?.map { documentSnapshot ->
            FavouritePost(
                id = documentSnapshot.get(FirebasePostsDatabaseManagerImpl.KEY_ID)
                    .toString(),
                userId = documentSnapshot.get(FirebasePostsDatabaseManagerImpl.KEY_USER_ID)
                    .toString(),
                images = documentSnapshot.get(FirebasePostsDatabaseManagerImpl.KEY_IMAGES)
                    .toString(),
                title = documentSnapshot.get(FirebasePostsDatabaseManagerImpl.KEY_TITLE)
                    .toString(),
                description = documentSnapshot.get(FirebasePostsDatabaseManagerImpl.KEY_DESCRIPTION)
                    .toString(),
                price = documentSnapshot.get(FirebasePostsDatabaseManagerImpl.KEY_PRICE)
                    .toString(),
                username = documentSnapshot.get(FirebasePostsDatabaseManagerImpl.KEY_USERNAME)
                    .toString(),
                email = documentSnapshot.get(FirebasePostsDatabaseManagerImpl.KEY_EMAIL)
                    .toString(),
                phoneNumber = documentSnapshot.get(FirebasePostsDatabaseManagerImpl.KEY_PHONE_NUMBER)
                    .toString(),
                date = documentSnapshot.get(FirebasePostsDatabaseManagerImpl.KEY_CREATED_AT)
                    .toString()
            )
        }
            ?: emptyList()
    }

    override suspend fun saveFavouritePost(post: Post, path: String) {
        favouritePostsRepository.saveFavouritePost(post.toFavouritePost(), path)
    }

    override suspend fun deleteFavouritePost(id: String, path: String) {
        favouritePostsRepository.deleteFavouritePost(id, path)
    }
}