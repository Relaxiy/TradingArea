package com.example.cars.app.data.room.userPosts

import com.example.cars.app.data.firebase.FirebasePostsDatabaseManager
import com.example.cars.app.data.room.userPosts.dao.UserPostsDao
import com.example.cars.app.data.room.userPosts.models.UserPostEntity
import com.example.cars.app.domain.UserPostsRepository
import com.example.cars.app.domain.models.UserPost
import com.example.cars.app.domain.models.UserPostResponse
import com.google.firebase.firestore.QuerySnapshot
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserPostsRepositoryImpl @Inject constructor(
    private val userPostsDao: UserPostsDao,
    private val firebaseDatabaseManager: FirebasePostsDatabaseManager
) : UserPostsRepository {

    override suspend fun getUserPosts(): List<UserPostEntity> {
        return withContext(Dispatchers.IO) {
            return@withContext userPostsDao.getUserPosts()
        }
    }

    override suspend fun getUserPostsFromFirebase(documentPath: String): QuerySnapshot? {
        return firebaseDatabaseManager.getUserPosts(documentPath)
    }

    override suspend fun saveUserPost(userPostEntity: UserPostEntity) {
        withContext(Dispatchers.IO) {
            userPostsDao.saveUserPost(userPostEntity)
        }
    }

    override suspend fun deleteUserPost(userPostEntity: UserPostEntity) {
        withContext(Dispatchers.IO){
            userPostsDao.deleteUserPost(userPostEntity)
        }
    }

    override suspend fun saveUserPostInFirestore(userPost: UserPost): String {
        return firebaseDatabaseManager.saveUserPost(userPost)
    }

    override suspend fun deleteUserPostInFirestore(userPostResponse: UserPostResponse) {
        firebaseDatabaseManager.deleteUserPost(userPostResponse)
    }

}