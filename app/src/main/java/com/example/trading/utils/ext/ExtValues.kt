package com.example.trading.utils.ext

import android.content.Context
import com.example.trading.app.di.MainActivityComponent
import com.example.trading.app.presentation.MainActivity


val Context.mainActivityComponent: MainActivityComponent
    get() = when (this) {
        is MainActivity -> mainActivityComponent
        else -> this.applicationContext.mainActivityComponent
    }