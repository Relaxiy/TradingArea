package com.example.trading.registration.di

import com.example.trading.utils.sharedPrefs.SharedPreferencesManager
import com.example.trading.utils.sharedPrefs.SharedPreferencesManagerImpl
import dagger.Binds
import dagger.Module

@Module
interface SharedPrefsModule {

    @Binds
    fun bindAuthSharedPrefs(sharedPreferencesManagerImpl: SharedPreferencesManagerImpl): SharedPreferencesManager

}