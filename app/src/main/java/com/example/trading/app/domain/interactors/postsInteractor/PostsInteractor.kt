package com.example.trading.app.domain.interactors.postsInteractor

import com.example.trading.app.domain.models.Post

interface PostsInteractor {

    suspend fun getPosts() : List<Post>
}