package com.example.trading.app.presentation.userPosts.userPost.actionSelector

sealed class DeletePostResult {

    data class SuccessResult(
        val success: String = "Post deleted"
    ) : DeletePostResult()
}
