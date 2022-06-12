package com.example.trading.app.domain.interactors.postsInteractor

import com.example.trading.app.domain.PostsRepository
import com.example.trading.app.domain.mappers.toBaseItems
import com.example.trading.app.domain.models.mainPage.BaseItem
import javax.inject.Inject

class PostsInteractorImpl @Inject constructor(
    private val postsRepository: PostsRepository
) : PostsInteractor {

    override suspend fun getPosts(userId: String): List<BaseItem> {
        return postsRepository.getPosts()?.toBaseItems(userId) ?: emptyList()
    }

}