package com.example.cars.registration.di

import android.content.Context
import androidx.lifecycle.ViewModelStoreOwner
import com.example.cars.app.presentation.personalPage.PersonalPageFragment
import com.example.cars.di.RoomModule
import com.example.cars.di.ViewModelFactory
import com.example.cars.registration.presentation.login.LoginActivity
import com.example.cars.registration.presentation.login.resetPassword.ForgetPasswordActivity
import com.example.cars.registration.presentation.register.RegisterActivity
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
}