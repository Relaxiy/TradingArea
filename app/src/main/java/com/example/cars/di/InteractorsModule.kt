package com.example.cars.di

import com.example.cars.app.domain.interactors.favouritePostsInteractor.FavouritePostsInteractor
import com.example.cars.app.domain.interactors.favouritePostsInteractor.FavouritePostsInteractorImpl
import com.example.cars.app.domain.interactors.userPostsInteractor.UserPostsInteractor
import com.example.cars.app.domain.interactors.userPostsInteractor.UserPostsInteractorImpl
import dagger.Binds
import dagger.Module

@Module
interface InteractorsModule {

    @Binds
    fun bindFavouritePostsInteractor(favouritePostsDbInteractorImpl: FavouritePostsInteractorImpl): FavouritePostsInteractor

    @Binds
    fun bindUserPostsInteractor(userPostsInteractorImpl: UserPostsInteractorImpl): UserPostsInteractor
}