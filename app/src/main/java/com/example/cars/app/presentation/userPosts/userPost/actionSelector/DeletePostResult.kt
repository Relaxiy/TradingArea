package com.example.cars.app.presentation.userPosts.userPost.actionSelector

sealed class DeletePostResult{

    data class SuccessResult(
        val success: String = "Post deleted"
    ) : DeletePostResult()
}
