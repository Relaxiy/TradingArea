package com.example.trading.app.data.repositories

import com.example.trading.app.data.firebase.favouritePosts.FirebaseFavouritePostsDatabaseManager
import com.example.trading.app.domain.FavouritePostsRepository
import com.example.trading.app.domain.models.FavouritePost
import com.google.firebase.firestore.QuerySnapshot
import javax.inject.Inject

class FavouritePostsRepositoryImpl @Inject constructor(
    private val favouritePostsDatabaseManager: FirebaseFavouritePostsDatabaseManager
) : FavouritePostsRepository{

    override suspend fun getFavouritePosts(path: String): QuerySnapshot? {
        return favouritePostsDatabaseManager.getFavouritePosts(path)
    }

    override suspend fun saveFavouritePost(favouritePost: FavouritePost, path: String) {
        favouritePostsDatabaseManager.saveFavouritePost(favouritePost, path)
    }

    override suspend fun deleteFavouritePost(id: String, path: String) {
        favouritePostsDatabaseManager.deleteFavouritePost(id, path)
    }

}