package com.example.trading.app.di

import com.example.trading.app.domain.interactors.favouritePostsInteractor.FavouritePostsInteractor
import com.example.trading.app.domain.interactors.favouritePostsInteractor.FavouritePostsInteractorImpl
import com.example.trading.app.domain.interactors.postsInteractor.PostsInteractor
import com.example.trading.app.domain.interactors.postsInteractor.PostsInteractorImpl
import com.example.trading.app.domain.interactors.userPostsInteractor.UserPostsInteractor
import com.example.trading.app.domain.interactors.userPostsInteractor.UserPostsInteractorImpl
import dagger.Binds
import dagger.Module

@Module
interface InteractorsModule {

    @Binds
    fun bindFavouritePostsInteractor(favouritePostsDbInteractorImpl: FavouritePostsInteractorImpl): FavouritePostsInteractor

    @Binds
    fun bindUserPostsInteractor(userPostsInteractorImpl: UserPostsInteractorImpl): UserPostsInteractor

    @Binds
    fun bindPostsInteractor(postsInteractorImpl: PostsInteractorImpl): PostsInteractor
}