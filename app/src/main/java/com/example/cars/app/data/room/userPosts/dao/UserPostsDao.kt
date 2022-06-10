package com.example.cars.app.data.room.userPosts.dao

import androidx.room.*
import com.example.cars.app.data.room.userPosts.models.UserPostEntity

@Dao
interface UserPostsDao {
    @Query("SELECT * FROM user_posts")
    suspend fun getUserPosts(): List<UserPostEntity>

    @Insert
    suspend fun saveUserPost(userPostEntity: UserPostEntity)

    @Update
    suspend fun updateUserPost(userPostEntity: UserPostEntity)

    @Delete
    suspend fun deleteUserPost(userPostEntity: UserPostEntity)
}