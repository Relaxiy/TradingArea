package com.example.trading.app.di

import android.content.Context
import androidx.room.Room
import com.example.trading.app.data.room.userPosts.dao.UserPostsDao
import com.example.trading.roomDatabase.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RoomModule {

    @Provides
    @Singleton
    fun provideUserPostsDao(database: AppDatabase): UserPostsDao{
        return database.getUserPostsDao()
    }

    @Provides
    @Singleton
    fun provideRoomDataBase(context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "database.db")
            .build()
}