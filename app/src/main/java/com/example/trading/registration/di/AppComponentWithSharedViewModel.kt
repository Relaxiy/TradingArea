package com.example.trading.registration.di

import android.content.Context
import androidx.lifecycle.ViewModelStoreOwner
import com.example.trading.app.presentation.addPost.AddPostFragment
import com.example.trading.app.presentation.personalPage.PersonalPageFragment
import com.example.trading.app.di.RoomModule
import com.example.trading.app.di.ViewModelFactory
import com.example.trading.registration.presentation.login.LoginActivity
import com.example.trading.registration.presentation.login.resetPassword.ForgetPasswordActivity
import com.example.trading.registration.presentation.register.RegisterActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        SharedViewModelsModule::class,
        SharedPrefsModule::class,
        FirebaseModule::class,
        InteractorsModule::class,
        RepositoriesModule::class,
        ViewModelsModule::class,
        RoomModule::class
    ]
)
interface AppComponentWithSharedViewModel {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun viewStore(viewModelStoreOwner: ViewModelStoreOwner): Builder

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponentWithSharedViewModel
    }

    fun viewModelsFactory(): ViewModelFactory
    fun inject(loginActivity: LoginActivity)
    fun inject(forgetPasswordActivity: ForgetPasswordActivity)
    fun inject(registerActivity: RegisterActivity)
    fun inject(personalPageFragment: PersonalPageFragment)
    fun inject(addPostFragment: AddPostFragment)
}