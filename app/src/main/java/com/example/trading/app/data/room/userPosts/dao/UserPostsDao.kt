package com.example.trading.app.data.room.userPosts.dao

import androidx.room.*
import com.example.trading.app.data.room.userPosts.models.UserPostEntity

@Dao
interface UserPostsDao {
    @Query("SELECT * FROM user_posts WHERE user_id = (:userId)")
    suspend fun getUserPosts(userId: String): List<UserPostEntity>

    @Insert
    suspend fun saveUserPost(userPostEntity: UserPostEntity)

    @Update
    suspend fun updateUserPost(userPostEntity: UserPostEntity)

    @Query("DELETE FROM user_posts WHERE id = (:id)")
    suspend fun deleteUserPost(id: String)
}