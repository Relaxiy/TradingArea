package com.example.trading.app.presentation.userPosts.userPost

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.trading.app.domain.models.UserPostResponse

class UserPostItemSharedViewModel : ViewModel() {

    val postItem: LiveData<UserPostResponse> get() = _postItem
    private val _postItem = MutableLiveData<UserPostResponse>()

    fun addPostOnInterface(postResponse: UserPostResponse){
        _postItem.value = postResponse
        Log.e("????", postItem.value.toString())
    }

}