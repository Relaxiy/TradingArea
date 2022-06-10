package com.example.cars.di

import com.example.cars.app.domain.FavouritePostsDbRepository
import com.example.cars.app.data.room.favouritePosts.FavouritePostsDbRepositoryImpl
import com.example.cars.app.domain.UserPostsRepository
import com.example.cars.app.data.room.userPosts.UserPostsRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface RepositoriesModule {
    @Binds
    fun bindFavouritePostsRepository(postsRepositoryImpl: FavouritePostsDbRepositoryImpl): FavouritePostsDbRepository

    @Binds
    fun bindUserPostsRepository(userPostsRepositoryImpl: UserPostsRepositoryImpl): UserPostsRepository

}