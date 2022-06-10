package com.example.trading.app.domain.interactors.userPostsInteractor

import android.content.Context
import com.example.trading.utils.ext.mainActivityComponent
import javax.inject.Inject

class UserPostsInteractorFactory {

    @Inject
    lateinit var userPostsInteractor: UserPostsInteractor

    fun getUserPostsInteractor(context: Context) : UserPostsInteractor{
        context.mainActivityComponent.inject(this)
        return userPostsInteractor
    }
}