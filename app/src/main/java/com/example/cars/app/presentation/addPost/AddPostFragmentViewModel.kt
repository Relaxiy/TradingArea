package com.example.cars.app.presentation.addPost

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cars.app.domain.interactors.userPostsInteractor.UserPostsInteractor
import com.example.cars.app.domain.models.UserPost
import com.example.cars.app.presentation.addPost.actionSelector.CreateUserPostResult
import com.example.cars.app.presentation.addPost.actionSelector.CreateUserPostResult.PostCreationFailed
import com.example.cars.app.presentation.addPost.actionSelector.CreateUserPostResult.PostCreationSuccess
import com.example.cars.utils.ext.isEmail
import com.example.cars.utils.ext.toLiteVersionPhoneNumber
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddPostFragmentViewModel @Inject constructor(
    private val userPostsInteractor: UserPostsInteractor
) : ViewModel() {

    val userPost: LiveData<UserPost> get() = _userPost
    private val _userPost = MutableLiveData<UserPost>()

    val validateUserPostResponse: LiveData<CreateUserPostResult> get() = _validateUserPostResponse
    private val _validateUserPostResponse = MutableLiveData<CreateUserPostResult>()

    fun savePost(
        userId: String,
        images: String?,
        title: String,
        description: String,
        price: String,
        personName: String,
        email: String,
        phoneNumber: String
    ) {
        val post = createPost(
            userId,
            images,
            title,
            description,
            price,
            personName,
            email,
            phoneNumber
        )
        if (validate(post)) {
            viewModelScope.launch {
                val userPostResponse = viewModelScope.async {
                    userPostsInteractor.saveUserPostInFirestore(post)
                }.await()
                viewModelScope.async {
                    userPostsInteractor.saveUserPostInRoom(userPostResponse)
                }.await()
                _validateUserPostResponse.postValue(PostCreationSuccess())
            }
        } else {
            _validateUserPostResponse.value = PostCreationFailed()
        }
    }

    private fun createPost(
        userId: String,
        images: String?,
        title: String,
        description: String,
        price: String,
        personName: String,
        email: String,
        phoneNumber: String
    ): UserPost {
        return UserPost(
            userId = userId,
            images = images,
            title = title,
            description = description,
            price = price,
            personName = personName,
            email = email,
            phoneNumber = phoneNumber
        )
    }

    private fun validate(userPost: UserPost): Boolean {
        userPost.apply {
            return title.isNotEmpty() &&
                    description.isNotEmpty() &&
                    price.isNotEmpty() &&
                    personName.isNotEmpty() &&
                    email.isNotEmpty() &&
                    phoneNumber.isNotEmpty() &&
                    email.isEmail()

        }
    }
}