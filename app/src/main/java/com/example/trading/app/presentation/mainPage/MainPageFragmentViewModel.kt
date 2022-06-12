package com.example.trading.app.presentation.mainPage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trading.app.domain.interactors.postsInteractor.PostsInteractor
import com.example.trading.app.domain.models.mainPage.BaseItem
import com.example.trading.app.domain.models.mainPage.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainPageFragmentViewModel @Inject constructor(
    private val postsInteractor: PostsInteractor
) : ViewModel() {

    val posts: LiveData<List<BaseItem>> get() = _posts
    private val _posts = MutableLiveData<List<BaseItem>>()

    fun loadPosts(userId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _posts.postValue(postsInteractor.getPosts(userId))
        }
    }
}