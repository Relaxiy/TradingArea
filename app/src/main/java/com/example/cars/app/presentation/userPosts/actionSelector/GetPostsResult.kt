package com.example.cars.app.presentation.userPosts.actionSelector

import com.example.cars.app.domain.models.UserPostResponse

sealed class GetPostsResult{
    data class SuccessResult(
        val success: List<UserPostResponse>
    ) : GetPostsResult()

    data class EmptyPostsResult(
        val empty: String = ""
    ) : GetPostsResult()
}
