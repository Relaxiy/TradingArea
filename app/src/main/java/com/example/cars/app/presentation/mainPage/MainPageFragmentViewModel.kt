package com.example.cars.app.presentation.mainPage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cars.app.domain.models.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainPageFragmentViewModel @Inject constructor() : ViewModel() {
    val posts: LiveData<List<Post>>get() = _posts
    private val _posts = MutableLiveData<List<Post>>()

    init {
        loadPosts()
    }

    private fun loadPosts(){
        viewModelScope.launch(Dispatchers.IO) {

        }
    }
}