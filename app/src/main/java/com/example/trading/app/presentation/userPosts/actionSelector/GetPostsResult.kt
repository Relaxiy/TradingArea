package com.example.trading.app.presentation.userPosts.actionSelector

import com.example.trading.app.domain.models.userPosts.UserPostResponse

sealed class GetPostsResult {
    data class SuccessResult(
        val success: List<UserPostResponse>
    ) : GetPostsResult()

    data class EmptyPostsResult(
        val empty: String = ""
    ) : GetPostsResult()
}
