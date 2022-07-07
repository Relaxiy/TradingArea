package com.example.trading.app.domain.mappers

import com.example.trading.app.data.room.favouritePosts.models.FavouritePostEntity
import com.example.trading.app.domain.models.favourites.FavouritePost
import com.example.trading.app.domain.models.mainPage.Post
import kotlin.math.log

fun Post.toFavouritePostEntity(loggedUserId: String) = FavouritePostEntity(
    id = id,
    loggedUserId = loggedUserId,
    images = images,
    title = title,
    price = price,
    date = date
)

fun FavouritePostEntity.toFavouritePost() = FavouritePost(
    id = id,
    loggedUserId = loggedUserId,
    images = images,
    title = title,
    price = price,
    date = date
)

fun FavouritePost.toFavouritePostEntity() = FavouritePostEntity(
    id = id,
    loggedUserId = loggedUserId,
    images = images,
    title = title,
    price = price,
    date = date
)