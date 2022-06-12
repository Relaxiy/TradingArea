package com.example.trading.app.presentation.mainPage

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.trading.app.domain.models.mainPage.Post
import com.example.trading.app.domain.models.userPosts.UserPostResponse

class PostItemSharedViewModel : ViewModel() {

    val userPostItem: LiveData<UserPostResponse> get() = _userPostItem
    private val _userPostItem = MutableLiveData<UserPostResponse>()

    val postItem: LiveData<Post> get() = _postItem
    private val _postItem = MutableLiveData<Post>()

    fun addUserPostOnInterface(postResponse: UserPostResponse) {
        _userPostItem.value = postResponse
    }

    fun addPostOnInterface(post: Post) {
        _postItem.value = post
    }
}