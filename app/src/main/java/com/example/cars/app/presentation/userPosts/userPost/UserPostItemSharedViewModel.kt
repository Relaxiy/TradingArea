package com.example.cars.app.presentation.userPosts.userPost

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cars.app.domain.interactors.userPostsInteractor.UserPostsInteractor
import com.example.cars.app.domain.interactors.userPostsInteractor.UserPostsInteractorFactory
import com.example.cars.app.domain.models.UserPostResponse
import com.example.cars.app.presentation.userPosts.userPost.actionSelector.DeletePostResult
import com.google.firebase.firestore.auth.User
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserPostItemSharedViewModel @Inject constructor() : ViewModel() {

    private val userPostsInteractorFactory = UserPostsInteractorFactory()
    val postItem: LiveData<UserPostResponse> get() = _postItem
    private val _postItem = MutableLiveData<UserPostResponse>()

    val deleteResult: LiveData<DeletePostResult> get() = _deleteResult
    private val _deleteResult = MutableLiveData<DeletePostResult>()

    fun addPostOnInterface(postResponse: UserPostResponse){
        _postItem.value = postResponse
    }

    fun deletePost(context: Context){
        viewModelScope.launch {
            viewModelScope.async {
                postItem.value?.let { userPostResponse ->
                    userPostsInteractorFactory.getUserPostsInteractor(context)
                        .deleteUserPostInRoom(userPostResponse)
                    userPostsInteractorFactory.getUserPostsInteractor(context)
                        .deleteUserPostInFirestore(userPostResponse)
                }
            }.await()
            _deleteResult.postValue(DeletePostResult.SuccessResult())
        }
    }
}