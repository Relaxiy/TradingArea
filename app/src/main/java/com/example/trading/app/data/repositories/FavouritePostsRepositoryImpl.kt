package com.example.trading.app.data.repositories

import com.example.trading.app.data.room.favouritePosts.dao.FavouritePostsDao
import com.example.trading.app.data.room.favouritePosts.models.FavouritePostEntity
import com.example.trading.app.domain.FavouritePostsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FavouritePostsRepositoryImpl @Inject constructor(
    private val favouritePostsDao: FavouritePostsDao
) : FavouritePostsRepository {

    override suspend fun getFavouritePosts(loggedUserId: String): List<FavouritePostEntity> {
        return withContext(Dispatchers.IO) {
            return@withContext favouritePostsDao.getFavouritePosts(loggedUserId)
        }
    }

    override suspend fun saveFavouritePost(favouritePostEntity: FavouritePostEntity) {
        return withContext(Dispatchers.IO) {
            return@withContext favouritePostsDao.saveFavouritePost(favouritePostEntity)
        }
    }

    override suspend fun deleteFavouritePost(id: String) {
        withContext(Dispatchers.IO) {
            favouritePostsDao.deleteFavouritePost(id)
        }
    }

}