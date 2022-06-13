package com.example.trading.di

import com.example.trading.registration.domain.interactor.AccountsInteractor
import com.example.trading.registration.domain.interactor.AccountsInteractorImpl
import com.example.trading.registration.domain.useCases.FindAccountByEmailUseCase
import com.example.trading.registration.domain.useCases.FindAccountByEmailUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface InteractorsModule {

    @Binds
    fun bindAccountInteractor(accountsInteractorImpl: AccountsInteractorImpl): AccountsInteractor

    @Binds
    fun bindFindAccountByEmailUseCase(findAccountByEmailUseCaseImpl: FindAccountByEmailUseCaseImpl): FindAccountByEmailUseCase

}