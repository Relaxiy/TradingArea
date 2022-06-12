package com.example.trading.app.di

import android.content.Context
import androidx.lifecycle.ViewModelStoreOwner
import com.example.trading.app.presentation.mainPage.MainPageFragment
import com.example.trading.app.presentation.mainPage.posts.PostItemFragment
import com.example.trading.app.presentation.userPosts.UserPostsFragment
import com.example.trading.app.presentation.userPosts.userPost.UserPostItemFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        SharedViewModule::class,
        FirebaseModule::class,
        InteractorsModule::class,
        RepositoriesModule::class,
        ViewModelsModule::class,
        RoomModule::class,
        SharedPrefsModule::class
    ]
)
interface MainActivityComponent {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun viewStore(viewModelStoreOwner: ViewModelStoreOwner): Builder

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): MainActivityComponent
    }

    fun viewModelsFactory(): ViewModelFactory
    fun inject(userPostItemFragment: UserPostItemFragment)
    fun inject(userPostsFragment: UserPostsFragment)
    fun inject(mainPageFragment: MainPageFragment)
    fun inject(postItemFragment: PostItemFragment)
}