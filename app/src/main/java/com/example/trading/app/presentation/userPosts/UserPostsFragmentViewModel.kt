package com.example.trading.app.presentation.userPosts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trading.app.domain.interactors.userPostsInteractor.UserPostsInteractor
import com.example.trading.app.domain.models.UserPostResponse
import com.example.trading.app.presentation.userPosts.actionSelector.GetPostsResult
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserPostsFragmentViewModel @Inject constructor(
    private val userPostsInteractor: UserPostsInteractor
) : ViewModel() {

    val userPosts: LiveData<List<UserPostResponse>> get() = _userPosts
    private val _userPosts = MutableLiveData<List<UserPostResponse>>()

    val getPostsResult: LiveData<GetPostsResult> get() = _getPostsResult
    private val _getPostsResult = MutableLiveData<GetPostsResult>()

    init {
        getUserPosts()
    }

    private fun getUserPosts(){
        viewModelScope.launch {
            _userPosts.postValue(
                viewModelScope.async {
                    userPostsInteractor.getUserPosts()
                }.await()
            )
        }
    }

    fun synchronizePosts(documentPath: String) {
        viewModelScope.launch {
            delay(1000)
            viewModelScope.async {
                if (userPosts.value.isNullOrEmpty()) {
                    _getPostsResult.postValue(
                        userPostsInteractor.getUserPostsFromFirebase(
                            documentPath
                        )
                    )
                }
            }.await()
        }
    }

    fun saveUserPostsInRoom(userPosts: List<UserPostResponse>) {
        viewModelScope.launch {
            viewModelScope.async {
                userPosts.map { userPostResponse ->
                    userPostsInteractor.saveUserPostInRoom(userPostResponse)
                }
            }.await()
            viewModelScope.launch {
                _userPosts.postValue(userPostsInteractor.getUserPosts())
            }
        }
    }

    fun deleteUserPost(userPostResponse: UserPostResponse) {

    }
}