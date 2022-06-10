package com.example.cars.registration.di

import com.example.cars.registration.data.AccountsRepositoryImpl
import com.example.cars.registration.domain.AccountsRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoriesModule {

    @Binds
    fun bindAccountsRepository(accountsRepositoryImpl: AccountsRepositoryImpl): AccountsRepository
}