package com.example.trading.utils.ext

import android.content.Context
import com.example.trading.CarApplication
import com.example.trading.app.di.MainActivityComponent
import com.example.trading.app.presentation.MainActivity
import com.example.trading.di.AppComponent

val Context.appComponent: AppComponent
    get() = when(this){
        is CarApplication -> appComponent
        else -> this.applicationContext.appComponent
    }

val Context.mainActivityComponent: MainActivityComponent
    get() = when (this) {
        is MainActivity -> mainActivityComponent
        else -> this.applicationContext.mainActivityComponent
    }