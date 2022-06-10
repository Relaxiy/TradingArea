package com.example.trading.di

import com.example.trading.app.domain.FavouritePostsDbRepository
import com.example.trading.app.data.room.favouritePosts.FavouritePostsDbRepositoryImpl
import com.example.trading.app.domain.UserPostsRepository
import com.example.trading.app.data.room.userPosts.UserPostsRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface RepositoriesModule {
    @Binds
    fun bindFavouritePostsRepository(postsRepositoryImpl: FavouritePostsDbRepositoryImpl): FavouritePostsDbRepository

    @Binds
    fun bindUserPostsRepository(userPostsRepositoryImpl: UserPostsRepositoryImpl): UserPostsRepository

}