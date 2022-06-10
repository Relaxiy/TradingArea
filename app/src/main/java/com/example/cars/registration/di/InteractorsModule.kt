package com.example.cars.registration.di

import com.example.cars.registration.domain.interactor.AccountsInteractor
import com.example.cars.registration.domain.interactor.AccountsInteractorImpl
import com.example.cars.registration.domain.useCases.FindAccountByEmailUseCase
import com.example.cars.registration.domain.useCases.FindAccountByEmailUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
interface InteractorsModule {

    @Binds
    fun bindAccountInteractor(accountsInteractorImpl: AccountsInteractorImpl): AccountsInteractor

    @Binds
    fun bindFindAccountByEmailUseCase(findAccountByEmailUseCaseImpl: FindAccountByEmailUseCaseImpl): FindAccountByEmailUseCase

}