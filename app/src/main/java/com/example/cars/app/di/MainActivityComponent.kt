package com.example.cars.app.di

import android.content.Context
import androidx.lifecycle.ViewModelStoreOwner
import com.example.cars.app.domain.interactors.userPostsInteractor.UserPostsInteractorFactory
import com.example.cars.app.presentation.userPosts.UserPostsFragment
import com.example.cars.app.presentation.userPosts.userPost.UserPostItemFragment
import com.example.cars.di.*
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
    fun inject(userPostsInteractorFactory: UserPostsInteractorFactory)
}