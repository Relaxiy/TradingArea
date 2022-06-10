package com.example.cars.app.data.room.favouritePosts

import com.example.cars.app.data.room.favouritePosts.dao.FavouritePostsDao
import com.example.cars.app.data.room.favouritePosts.models.FavouritePostEntity
import com.example.cars.app.domain.FavouritePostsDbRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FavouritePostsDbRepositoryImpl @Inject constructor(
    private val postsDao: FavouritePostsDao
) : FavouritePostsDbRepository {

    override suspend fun getFavouritePosts(): List<FavouritePostEntity> {
        return withContext(Dispatchers.IO){
            return@withContext postsDao.getFavouritePosts()
        }
    }

    override suspend fun saveFavouritePost(favouritePostEntity: FavouritePostEntity) {
       withContext(Dispatchers.IO){
           postsDao.saveFavouritePost(favouritePostEntity)
       }
    }

    override suspend fun deleteFavouritePost(favouritePostEntity: FavouritePostEntity) {
        withContext(Dispatchers.IO){
            postsDao.deleteFavouritePost(favouritePostEntity)
        }
    }

}