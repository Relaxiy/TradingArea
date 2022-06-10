package com.example.cars.di

import com.example.cars.utils.sharedPrefs.SharedPreferencesManager
import com.example.cars.utils.sharedPrefs.SharedPreferencesManagerImpl
import dagger.Binds
import dagger.Module

@Module
interface SharedPrefsModule {

    @Binds
    fun bindAuthSharedPrefs(sharedPreferencesManagerImpl: SharedPreferencesManagerImpl): SharedPreferencesManager

}