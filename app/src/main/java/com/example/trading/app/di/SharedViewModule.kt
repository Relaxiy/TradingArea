package com.example.trading.app.di

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.example.trading.app.presentation.mainPage.PostItemSharedViewModel
import dagger.Module
import dagger.Provides

@Module
class SharedViewModule {
    @Provides
    fun providePostItemSharedViewModel(
        viewModelStoreOwner: ViewModelStoreOwner
    ): PostItemSharedViewModel {
        return ViewModelProvider(viewModelStoreOwner)[PostItemSharedViewModel::class.java]
    }

}
