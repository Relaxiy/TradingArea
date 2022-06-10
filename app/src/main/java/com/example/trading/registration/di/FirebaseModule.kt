package com.example.trading.registration.di

import com.example.trading.registration.data.firebase.FirebaseUsersDatabaseManager
import com.example.trading.registration.data.firebase.FirebaseUsersDatabaseManagerImpl
import dagger.Binds
import dagger.Module

@Module
interface FirebaseModule {
    @Binds
    fun bindFirebaseDatabaseManager(firebaseDatabaseManagerImpl: FirebaseUsersDatabaseManagerImpl): FirebaseUsersDatabaseManager
}