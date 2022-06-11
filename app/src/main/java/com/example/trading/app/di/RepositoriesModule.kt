package com.example.trading.app.di

import com.example.trading.app.data.repositories.FavouritePostsRepositoryImpl
import com.example.trading.app.data.repositories.PostsRepositoryImpl
import com.example.trading.app.domain.FavouritePostsRepository
import com.example.trading.app.domain.UserPostsRepository
import com.example.trading.app.data.repositories.UserPostsRepositoryImpl
import com.example.trading.app.domain.PostsRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoriesModule {
    @Binds
    fun bindFavouritePostsRepository(favouritePostsRepositoryImpl: FavouritePostsRepositoryImpl): FavouritePostsRepository

    @Binds
    fun bindUserPostsRepository(userPostsRepositoryImpl: UserPostsRepositoryImpl): UserPostsRepository

    @Binds
    fun bindPostsRepository(postsRepositoryImpl: PostsRepositoryImpl): PostsRepository

}