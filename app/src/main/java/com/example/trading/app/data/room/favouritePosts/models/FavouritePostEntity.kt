package com.example.trading.app.data.room.favouritePosts.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.trading.app.data.room.favouritePosts.models.FavouritePostEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class FavouritePostEntity(
    @PrimaryKey(autoGenerate = true)
    var uid: Long = 0,
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "logged_user_id")
    val loggedUserId: String,
    @ColumnInfo(name = "images")
    val images: String?,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "description")
    val price: String,
    @ColumnInfo(name = "current_date")
    val date: String
) {
    companion object {
        const val TABLE_NAME = "favourite_posts"
    }
}
