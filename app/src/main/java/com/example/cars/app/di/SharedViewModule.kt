package com.example.cars.app.di

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.example.cars.app.presentation.userPosts.userPost.UserPostItemSharedViewModel
import dagger.Module
import dagger.Provides

@Module
class SharedViewModule{
    @Provides
    fun provideUserSharedViewModel(
        viewModelStoreOwner: ViewModelStoreOwner
    ): UserPostItemSharedViewModel {
        return ViewModelProvider(viewModelStoreOwner)[UserPostItemSharedViewModel::class.java]
    }
}
