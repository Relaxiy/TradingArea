package com.example.trading.app.domain.interactors.postsInteractor

import com.example.trading.app.domain.models.mainPage.BaseItem

interface PostsInteractor {

    suspend fun getPosts(userId: String): List<BaseItem>
}