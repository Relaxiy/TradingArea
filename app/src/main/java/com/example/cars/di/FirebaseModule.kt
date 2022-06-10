package com.example.cars.di

import com.example.cars.app.data.firebase.FirebasePostsDatabaseManager
import com.example.cars.app.data.firebase.FirebasePostsDatabaseManagerImpl
import dagger.Binds
import dagger.Module

@Module
interface FirebaseModule {

    @Binds
    fun bindFirebasePostsDatabaseManager(firebasePostsDatabaseManagerImpl: FirebasePostsDatabaseManagerImpl): FirebasePostsDatabaseManager
}