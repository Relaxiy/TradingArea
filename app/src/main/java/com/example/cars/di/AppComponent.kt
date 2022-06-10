package com.example.cars.di

import android.content.Context
import com.example.cars.app.presentation.addPost.AddPostFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        InteractorsModule::class,
        RepositoriesModule::class,
        ViewModelsModule::class,
        RoomModule::class,
        FirebaseModule::class,
        SharedPrefsModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }

    fun viewModelsFactory(): ViewModelFactory

    fun inject(addPostFragment: AddPostFragment)
}