package com.example.cars.di

import android.content.Context
import androidx.room.Room
import com.example.cars.app.data.room.favouritePosts.dao.FavouritePostsDao
import com.example.cars.app.data.room.userPosts.dao.UserPostsDao
import com.example.cars.roomDatabase.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RoomModule {

    @Provides
    @Singleton
    fun provideFavouritePostsDao(database: AppDatabase): FavouritePostsDao {
        return database.getFavouritePostsDao()
    }

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