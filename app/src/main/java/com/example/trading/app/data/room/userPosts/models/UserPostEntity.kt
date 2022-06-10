package com.example.trading.app.data.room.userPosts.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.trading.app.data.room.userPosts.models.UserPostEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class UserPostEntity(
    @PrimaryKey(autoGenerate = true)
    var uid: Long = 0,
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "user_id")
    val userId: String,
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
        const val TABLE_NAME = "user_posts"
    }
}
