package com.example.trading.app.di

import com.example.trading.app.data.firebase.favouritePosts.FirebaseFavouritePostsDatabaseManager
import com.example.trading.app.data.firebase.favouritePosts.FirebaseFavouritePostsDatabaseManagerImpl
import com.example.trading.app.data.firebase.posts.FirebasePostsDatabaseManager
import com.example.trading.app.data.firebase.posts.FirebasePostsDatabaseManagerImpl
import com.example.trading.app.data.firebase.userPosts.FirebaseUserPostsDatabaseManager
import com.example.trading.app.data.firebase.userPosts.FirebaseUserPostsDatabaseManagerImpl
import dagger.Binds
import dagger.Module

@Module
interface FirebaseModule {

    @Binds
    fun bindFirebaseUserPostsDatabaseManager(firebaseUserPostsDatabaseManagerImpl: FirebaseUserPostsDatabaseManagerImpl): FirebaseUserPostsDatabaseManager

    @Binds
    fun bindFirebasePostsDatabaseManager(firebasePostsDatabaseManagerImpl: FirebasePostsDatabaseManagerImpl): FirebasePostsDatabaseManager

    @Binds
    fun bindFirebaseFavouritePostsDatabaseManager(firebaseFavouritePostsDatabaseManagerImpl: FirebaseFavouritePostsDatabaseManagerImpl): FirebaseFavouritePostsDatabaseManager
}