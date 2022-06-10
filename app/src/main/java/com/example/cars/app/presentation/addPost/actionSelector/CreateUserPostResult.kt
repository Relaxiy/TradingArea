package com.example.cars.app.presentation.addPost.actionSelector

sealed class CreateUserPostResult{
    data class PostCreationSuccess(
        val success: String = "Success"
    ) : CreateUserPostResult()
    data class PostCreationFailed(
        val failed: String = "Failed"
    ) : CreateUserPostResult()
}
