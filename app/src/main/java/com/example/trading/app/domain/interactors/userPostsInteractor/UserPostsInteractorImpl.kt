package com.example.trading.app.domain.interactors.userPostsInteractor

import com.example.trading.app.data.firebase.userPosts.FirebaseUserPostsDatabaseManagerImpl.Companion.KEY_CREATED_AT
import com.example.trading.app.data.firebase.userPosts.FirebaseUserPostsDatabaseManagerImpl.Companion.KEY_DESCRIPTION
import com.example.trading.app.data.firebase.userPosts.FirebaseUserPostsDatabaseManagerImpl.Companion.KEY_EMAIL
import com.example.trading.app.data.firebase.userPosts.FirebaseUserPostsDatabaseManagerImpl.Companion.KEY_IMAGES
import com.example.trading.app.data.firebase.userPosts.FirebaseUserPostsDatabaseManagerImpl.Companion.KEY_PHONE_NUMBER
import com.example.trading.app.data.firebase.userPosts.FirebaseUserPostsDatabaseManagerImpl.Companion.KEY_PRICE
import com.example.trading.app.data.firebase.userPosts.FirebaseUserPostsDatabaseManagerImpl.Companion.KEY_TITLE
import com.example.trading.app.data.firebase.userPosts.FirebaseUserPostsDatabaseManagerImpl.Companion.KEY_USERNAME
import com.example.trading.app.data.firebase.userPosts.FirebaseUserPostsDatabaseManagerImpl.Companion.KEY_USER_ID
import com.example.trading.app.domain.PostsRepository
import com.example.trading.app.domain.UserPostsRepository
import com.example.trading.app.domain.mappers.toPost
import com.example.trading.app.domain.mappers.toUserPostEntity
import com.example.trading.app.domain.mappers.toUserPostResponse
import com.example.trading.app.domain.models.userPosts.UserPost
import com.example.trading.app.domain.models.userPosts.UserPostResponse
import com.example.trading.app.presentation.userPosts.actionSelector.GetPostsResult
import javax.inject.Inject

class UserPostsInteractorImpl @Inject constructor(
    private val userPostsRepository: UserPostsRepository,
    private val postsRepository: PostsRepository
) : UserPostsInteractor {

    override suspend fun getUserPosts(userId: String): List<UserPostResponse> {
        return userPostsRepository.getUserPosts(userId).map { userPostEntity ->
            userPostEntity.toUserPostResponse()
        }
    }

    override suspend fun getUserPostsFromFirebase(documentPath: String): GetPostsResult {
        return try {
            val documentsList =
                userPostsRepository.getUserPostsFromFirebase(documentPath)?.documents
            if (documentsList != null && documentsList.isNotEmpty()) {
                GetPostsResult.SuccessResult(
                    documentsList.map { documentSnapshot ->
                        UserPostResponse(
                            id = documentSnapshot.id,
                            userId = documentSnapshot.get(KEY_USER_ID).toString(),
                            images = documentSnapshot.get(KEY_IMAGES).toString(),
                            title = documentSnapshot.get(KEY_TITLE).toString(),
                            description = documentSnapshot.get(KEY_DESCRIPTION).toString(),
                            price = documentSnapshot.get(KEY_PRICE).toString(),
                            username = documentSnapshot.get(KEY_USERNAME).toString(),
                            email = documentSnapshot.get(KEY_EMAIL).toString(),
                            phoneNumber = documentSnapshot.get(KEY_PHONE_NUMBER).toString(),
                            date = documentSnapshot.get(KEY_CREATED_AT).toString()
                        )
                    }
                )
            } else {
                GetPostsResult.EmptyPostsResult()
            }
        } catch (e: Exception) {
            GetPostsResult.EmptyPostsResult()
        }
    }

    override suspend fun saveUserPostInRoom(userPostResponse: UserPostResponse) {
        userPostsRepository.saveUserPost(
            userPostEntity = userPostResponse.toUserPostEntity()
        )
    }

    override suspend fun deleteUserPostInRoom(id: String) {
        userPostsRepository.deleteUserPost(id)
    }

    override suspend fun saveUserPostInFirestore(userPost: UserPost): UserPostResponse {
        val postResponse =
            userPost.toUserPostResponse(userPostsRepository.saveUserPostInFirestore(userPost))
        postsRepository.savePost(postResponse.toPost())
        return postResponse
    }

    override suspend fun deleteUserPostInFirestore(userPostResponse: UserPostResponse) {
        userPostsRepository.deleteUserPostInFirestore(userPostResponse)
        postsRepository.deletePost(userPostResponse.id)
    }


}