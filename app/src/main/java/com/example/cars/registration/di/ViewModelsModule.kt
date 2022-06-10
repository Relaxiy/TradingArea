package com.example.cars.registration.di

import androidx.lifecycle.ViewModel
import com.example.cars.di.ViewModelKey
import com.example.cars.registration.presentation.login.LoginActivityViewModel
import com.example.cars.registration.presentation.login.resetPassword.ForgetPasswordActivityViewModel
import com.example.cars.registration.presentation.register.RegisterActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelKey(RegisterActivityViewModel::class)
    fun provideRegisterActivityViewModel(registerActivityViewModel: RegisterActivityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoginActivityViewModel::class)
    fun provideLoginActivityViewModel(loginActivityViewModel: LoginActivityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ForgetPasswordActivityViewModel::class)
    fun provideForgetPasswordFragmentViewModel(forgetPasswordActivityViewModel: ForgetPasswordActivityViewModel): ViewModel
}