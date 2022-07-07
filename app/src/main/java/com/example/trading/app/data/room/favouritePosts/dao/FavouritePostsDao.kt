package com.example.trading.app.data.room.favouritePosts.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.trading.app.data.room.favouritePosts.models.FavouritePostEntity

@Dao
interface FavouritePostsDao {
    @Query("SELECT * FROM favourite_posts WHERE logged_user_id = (:userId)")
    suspend fun getFavouritePosts(userId: String): List<FavouritePostEntity>

    @Insert
    suspend fun saveFavouritePost(favouritePostEntity: FavouritePostEntity)

    @Query("DELETE FROM favourite_posts WHERE id = (:id)")
    suspend fun deleteFavouritePost(id: String)

}