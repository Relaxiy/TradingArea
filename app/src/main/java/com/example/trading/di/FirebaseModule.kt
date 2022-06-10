package com.example.trading.di

import com.example.trading.app.data.firebase.FirebasePostsDatabaseManager
import com.example.trading.app.data.firebase.FirebasePostsDatabaseManagerImpl
import dagger.Binds
import dagger.Module

@Module
interface FirebaseModule {

    @Binds
    fun bindFirebasePostsDatabaseManager(firebasePostsDatabaseManagerImpl: FirebasePostsDatabaseManagerImpl): FirebasePostsDatabaseManager
}