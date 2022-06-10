package com.example.trading.registration.di

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.example.trading.app.presentation.personalPage.UserSharedViewModel
import dagger.Module
import dagger.Provides

@Module
class SharedViewModelsModule {

    @Provides
    fun provideUserSharedViewModel(
        viewModelStoreOwner: ViewModelStoreOwner
    ): UserSharedViewModel {
        return ViewModelProvider(viewModelStoreOwner)[UserSharedViewModel::class.java]
    }
}