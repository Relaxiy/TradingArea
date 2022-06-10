package com.example.trading.di

import androidx.lifecycle.ViewModel
import com.example.trading.app.presentation.MainActivityViewModel
import com.example.trading.app.presentation.addPost.AddPostFragmentViewModel
import com.example.trading.app.presentation.chatsPage.ChatsFragmentViewModel
import com.example.trading.app.presentation.favouritePosts.FavouritePostsFragmentViewModel
import com.example.trading.app.presentation.mainPage.MainPageFragmentViewModel
import com.example.trading.app.presentation.chatsPage.messages.MessagesFragmentViewModel
import com.example.trading.app.presentation.personalPage.PersonalPageFragmentViewModel
import com.example.trading.app.presentation.userPosts.UserPostsFragmentViewModel
import dagger.Binds
import dagger.Module
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