package com.example.cars.roomDatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cars.app.data.room.favouritePosts.dao.FavouritePostsDao
import com.example.cars.app.data.room.favouritePosts.models.FavouritePostEntity
import com.example.cars.app.data.room.userPosts.dao.UserPostsDao
import com.example.cars.app.data.room.userPosts.models.UserPostEntity
import com.example.cars.roomDatabase.AppDatabase.Companion.DATABASE_VERSION

@Database(
    version = DATABASE_VERSION,
    entities = [
        FavouritePostEntity::class,
        UserPostEntity::class
    ]
)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val DATABASE_VERSION = 1
    }

    abstract fun getFavouritePostsDao(): FavouritePostsDao

    abstract fun getUserPostsDao(): UserPostsDao
}