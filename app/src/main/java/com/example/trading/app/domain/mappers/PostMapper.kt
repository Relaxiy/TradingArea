package com.example.trading.app.domain.mappers

import com.example.trading.app.data.firebase.posts.FirebasePostsDatabaseManagerImpl
import com.example.trading.app.data.firebase.userPosts.FirebaseUserPostsDatabaseManagerImpl
import com.example.trading.app.domain.models.mainPage.BaseItem
import com.example.trading.app.domain.models.mainPage.Date
import com.example.trading.app.domain.models.mainPage.Post
import com.example.trading.app.domain.models.userPosts.UserPostResponse
import com.example.trading.utils.ext.toDate
import com.google.firebase.firestore.QuerySnapshot

fun UserPostResponse.toPost() = Post(
    id = id,
    userId = userId,
    images = images,
    title = title,
    description = description,
    price = price,
    username = username,
    email = email,
    phoneNumber = phoneNumber,
    date = date
)

fun QuerySnapshot.toBaseItems(userId: String): List<BaseItem> {
    val items = mutableListOf<BaseItem>()
    val reversedList = this.documents.reversed()
    reversedList.forEachIndexed { index, item ->
        if (index == 0) {
            items.add(
                Date(item.get(FirebasePostsDatabaseManagerImpl.KEY_CREATED_AT).toString().toDate())
            )
        } else if (item.get(FirebasePostsDatabaseManagerImpl.KEY_CREATED_AT).toString().toDate()
            != reversedList[index - 1].get(FirebasePostsDatabaseManagerImpl.KEY_CREATED_AT)
                .toString().toDate()
        ) {
            items.add(
                Date(item.get(FirebasePostsDatabaseManagerImpl.KEY_CREATED_AT).toString().toDate())
            )
        }
        if (userId == item.get(FirebasePostsDatabaseManagerImpl.KEY_USER_ID)
                .toString()
        ) {
            items.add(
                UserPostResponse(
                    id = item.get(FirebasePostsDatabaseManagerImpl.KEY_ID)
                        .toString(),
                    userId = item.get(FirebaseUserPostsDatabaseManagerImpl.KEY_USER_ID)
                        .toString(),
                    images = item.get(FirebaseUserPostsDatabaseManagerImpl.KEY_IMAGES)
                        .toString(),
                    title = item.get(FirebaseUserPostsDatabaseManagerImpl.KEY_TITLE)
                        .toString(),
                    description = item.get(FirebaseUserPostsDatabaseManagerImpl.KEY_DESCRIPTION)
                        .toString(),
                    price = item.get(FirebaseUserPostsDatabaseManagerImpl.KEY_PRICE)
                        .toString(),
                    username = item.get(FirebaseUserPostsDatabaseManagerImpl.KEY_USERNAME)
                        .toString(),
                    email = item.get(FirebaseUserPostsDatabaseManagerImpl.KEY_EMAIL)
                        .toString(),
                    phoneNumber = item.get(FirebaseUserPostsDatabaseManagerImpl.KEY_PHONE_NUMBER)
                        .toString(),
                    date = item.get(FirebaseUserPostsDatabaseManagerImpl.KEY_CREATED_AT)
                        .toString()
                )
            )
        } else {
            items.add(
                Post(
                    id = item.get(FirebasePostsDatabaseManagerImpl.KEY_ID)
                        .toString(),
                    userId = item.get(FirebasePostsDatabaseManagerImpl.KEY_USER_ID)
                        .toString(),
                    images = item.get(FirebasePostsDatabaseManagerImpl.KEY_IMAGES)
                        .toString(),
                    title = item.get(FirebasePostsDatabaseManagerImpl.KEY_TITLE)
                        .toString(),
                    description = item.get(FirebasePostsDatabaseManagerImpl.KEY_DESCRIPTION)
                        .toString(),
                    price = item.get(FirebasePostsDatabaseManagerImpl.KEY_PRICE)
                        .toString(),
                    username = item.get(FirebasePostsDatabaseManagerImpl.KEY_USERNAME)
                        .toString(),
                    email = item.get(FirebasePostsDatabaseManagerImpl.KEY_EMAIL)
                        .toString(),
                    phoneNumber = item.get(FirebasePostsDatabaseManagerImpl.KEY_PHONE_NUMBER)
                        .toString(),
                    date = item.get(FirebasePostsDatabaseManagerImpl.KEY_CREATED_AT)
                        .toString()
                )
            )
        }
    }
    return items
}
