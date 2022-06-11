package com.example.trading.app.presentation.userPosts.userPost

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trading.app.domain.interactors.userPostsInteractor.UserPostsInteractor
import com.example.trading.app.domain.models.UserPostResponse
import com.example.trading.app.presentation.userPosts.userPost.actionSelector.DeletePostResult
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserPostItemFragmentViewModel  @Inject constructor(private val userPostsInteractor: UserPostsInteractor) : ViewModel() {

    val postItem: LiveData<UserPostResponse> get() = _postItem
    private val _postItem = MutableLiveData<UserPostResponse>()

    val deleteResult: LiveData<DeletePostResult> get() = _deleteResult
    private val _deleteResult = MutableLiveData<DeletePostResult>()

    fun saveData(userPostResponse: UserPostResponse){
        _postItem.value = userPostResponse
    }

    fun deletePost(){
        viewModelScope.launch {
            viewModelScope.async {
                postItem.value?.let { userPostResponse ->
                    userPostsInteractor
                        .deleteUserPostInRoom(userPostResponse.id)
                    userPostsInteractor
                        .deleteUserPostInFirestore(userPostResponse)
                }
            }.await()
            _deleteResult.postValue(DeletePostResult.SuccessResult())
        }
    }
}