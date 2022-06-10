package com.example.cars.app.domain.interactors.userPostsInteractor

import android.content.Context
import com.example.cars.utils.ext.mainActivityComponent
import javax.inject.Inject

class UserPostsInteractorFactory {

    @Inject
    lateinit var userPostsInteractor: UserPostsInteractor

    fun getUserPostsInteractor(context: Context) : UserPostsInteractor{
        context.mainActivityComponent.inject(this)
        return userPostsInteractor
    }
}