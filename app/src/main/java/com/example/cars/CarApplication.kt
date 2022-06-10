package com.example.cars

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModelStoreOwner
import com.example.cars.di.AppComponent
import com.example.cars.di.DaggerAppComponent
import com.example.cars.registration.di.AppComponentWithSharedViewModel
import com.example.cars.registration.di.DaggerAppComponentWithSharedViewModel


class CarApplication : Application() {

    lateinit var appComponent: AppComponent

    companion object{
    lateinit var appComponentWithSharedViewModel: AppComponentWithSharedViewModel
    fun initAppComponentWithSharedViewModel(viewModelStoreOwner: ViewModelStoreOwner, context: Context) {
        appComponentWithSharedViewModel = DaggerAppComponentWithSharedViewModel.builder()
            .viewStore(viewModelStoreOwner)
            .context(context)
            .build()
    }
    }
    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .context(this)
            .build()
    }


}