package com.example.cars.app.data.room.favouritePosts.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cars.app.data.room.favouritePosts.models.FavouritePostEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class FavouritePostEntity(
    @PrimaryKey(autoGenerate = true)
    var uid: Long = 0,
    @ColumnInfo(name = "images")
    val images: String?,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "price")
    val price: String,
    @ColumnInfo(name = "person_name")
    val personName: String,
    @ColumnInfo(name = "email")
    val email: String,
    @ColumnInfo(name = "phone_number")
    val phoneNumber: String,
    @ColumnInfo(name = "current_date")
    var date: String
) {
    companion object {
        const val TABLE_NAME = "favourite_posts"
    }
}