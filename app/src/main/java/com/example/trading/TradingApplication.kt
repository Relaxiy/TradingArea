package com.example.trading

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModelStoreOwner
import com.example.trading.di.AppComponent
import com.example.trading.di.DaggerAppComponent
import com.example.trading.registration.di.AppComponentWithSharedViewModel
import com.example.trading.registration.di.DaggerAppComponentWithSharedViewModel


class TradingApplication : Application() {

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