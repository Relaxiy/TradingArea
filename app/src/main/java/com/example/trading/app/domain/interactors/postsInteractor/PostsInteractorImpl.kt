package com.example.trading.app.domain.interactors.postsInteractor

import com.example.trading.app.data.firebase.posts.FirebasePostsDatabaseManagerImpl.Companion.KEY_CREATED_AT
import com.example.trading.app.data.firebase.posts.FirebasePostsDatabaseManagerImpl.Companion.KEY_DESCRIPTION
import com.example.trading.app.data.firebase.posts.FirebasePostsDatabaseManagerImpl.Companion.KEY_EMAIL
import com.example.trading.app.data.firebase.posts.FirebasePostsDatabaseManagerImpl.Companion.KEY_ID
import com.example.trading.app.data.firebase.posts.FirebasePostsDatabaseManagerImpl.Companion.KEY_IMAGES
import com.example.trading.app.data.firebase.posts.FirebasePostsDatabaseManagerImpl.Companion.KEY_PHONE_NUMBER
import com.example.trading.app.data.firebase.posts.FirebasePostsDatabaseManagerImpl.Companion.KEY_PRICE
import com.example.trading.app.data.firebase.posts.FirebasePostsDatabaseManagerImpl.Companion.KEY_TITLE
import com.example.trading.app.data.firebase.posts.FirebasePostsDatabaseManagerImpl.Companion.KEY_USERNAME
import com.example.trading.app.data.firebase.posts.FirebasePostsDatabaseManagerImpl.Companion.KEY_USER_ID
import com.example.trading.app.domain.PostsRepository
import com.example.trading.app.domain.models.Post
import javax.inject.Inject

class PostsInteractorImpl @Inject constructor(
    private val postsRepository: PostsRepository
) : PostsInteractor {

    override suspend fun getPosts() : List<Post>{
        val postsList = postsRepository.getPosts()
        return postsList?.map { documentSnapshot ->
            Post(
                id = documentSnapshot.get(KEY_ID)
                    .toString(),
                userId = documentSnapshot.get(KEY_USER_ID)
                    .toString(),
                images = documentSnapshot.get(KEY_IMAGES)
                    .toString(),
                title = documentSnapshot.get(KEY_TITLE)
                    .toString(),
                description = documentSnapshot.get(KEY_DESCRIPTION)
                    .toString(),
                price = documentSnapshot.get(KEY_PRICE)
                    .toString(),
                personName = documentSnapshot.get(KEY_USERNAME)
                    .toString(),
                email = documentSnapshot.get(KEY_EMAIL)
                    .toString(),
                phoneNumber = documentSnapshot.get(KEY_PHONE_NUMBER)
                    .toString(),
                date = documentSnapshot.get(KEY_CREATED_AT)
                    .toString()
            )
        }
            ?: emptyList()
    }

}