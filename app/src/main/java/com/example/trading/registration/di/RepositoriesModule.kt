package com.example.trading.registration.di

import com.example.trading.registration.data.AccountsRepositoryImpl
import com.example.trading.registration.domain.AccountsRepository
import dagger.Binds
import dagger.Module

@Module
interface RepositoriesModule {

    @Binds
    fun bindAccountsRepository(accountsRepositoryImpl: AccountsRepositoryImpl): AccountsRepository
}