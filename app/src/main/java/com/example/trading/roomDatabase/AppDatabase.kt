package com.example.trading.roomDatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.trading.app.data.room.userPosts.dao.UserPostsDao
import com.example.trading.app.data.room.userPosts.models.UserPostEntity
import com.example.trading.roomDatabase.AppDatabase.Companion.DATABASE_VERSION

@Database(
    version = DATABASE_VERSION,
    entities = [
        UserPostEntity::class
    ]
)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val DATABASE_VERSION = 1
    }

    abstract fun getUserPostsDao(): UserPostsDao
}