package com.example.cars.registration.di

import com.example.cars.registration.data.firebase.FirebaseUsersDatabaseManager
import com.example.cars.registration.data.firebase.FirebaseUsersDatabaseManagerImpl
import dagger.Binds
import dagger.Module

@Module
interface FirebaseModule {
    @Binds
    fun bindFirebaseDatabaseManager(firebaseDatabaseManagerImpl: FirebaseUsersDatabaseManagerImpl): FirebaseUsersDatabaseManager
}