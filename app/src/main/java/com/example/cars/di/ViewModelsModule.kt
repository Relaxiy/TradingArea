package com.example.cars.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.example.cars.app.presentation.MainActivityViewModel
import com.example.cars.app.presentation.addPost.AddPostFragmentViewModel
import com.example.cars.app.presentation.chatsPage.ChatsFragmentViewModel
import com.example.cars.app.presentation.favouritePosts.FavouritePostsFragmentViewModel
import com.example.cars.app.presentation.mainPage.MainPageFragmentViewModel
import com.example.cars.app.presentation.chatsPage.messages.MessagesFragmentViewModel
import com.example.cars.app.presentation.personalPage.PersonalPageFragmentViewModel
import com.example.cars.app.presentation.personalPage.UserSharedViewModel
import com.example.cars.app.presentation.userPosts.UserPostsFragmentViewModel
import com.example.cars.registration.presentation.login.LoginActivityViewModel
import com.example.cars.registration.presentation.register.RegisterActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
interface ViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelKey(AddPostFragmentViewModel::class)
    fun provideAddCarFragmentViewModel(addPostFragmentViewModel: AddPostFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FavouritePostsFragmentViewModel::class)
    fun provideFavouritePostsFragmentViewModel(favouritePostsFragmentViewModel: FavouritePostsFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    fun provideMainActivityViewModel(mainActivityViewModel: MainActivityViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MainPageFragmentViewModel::class)
    fun provideMainPageFragmentViewModel(mainPageFragmentViewModel: MainPageFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PersonalPageFragmentViewModel::class)
    fun providePersonalPageFragmentViewModel(personalPageFragmentViewModel: PersonalPageFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(UserPostsFragmentViewModel::class)
    fun provideUserPostsFragmentViewModel(userPostsFragmentViewModel: UserPostsFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ChatsFragmentViewModel::class)
    fun provideChatsFragmentViewModel(chatsFragmentViewModel: ChatsFragmentViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MessagesFragmentViewModel::class)
    fun provideMessagesFragmentViewModel(messagesFragmentViewModel: MessagesFragmentViewModel): ViewModel
}