package com.example.cars.app.presentation.userPosts.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.cars.R
import com.example.cars.app.domain.models.UserPost
import com.example.cars.app.domain.models.UserPostResponse

class UserPostsViewHolder(
    itemView: View,
    private val openPost: (userPostResponse: UserPostResponse)-> Unit
) : RecyclerView.ViewHolder(itemView) {
    companion object {
        fun newInstance(
            parent: ViewGroup,
            openPost: (userPostResponse: UserPostResponse)-> Unit
        ) = UserPostsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.post_item,
                    parent,
                    false
                ),
            openPost
        )
    }

    private val postTitle by lazy {
        itemView.findViewById<TextView>(R.id.post_title)
    }

    private val postPrice by lazy {
        itemView.findViewById<TextView>(R.id.post_price)
    }

    private val postDate by lazy {
        itemView.findViewById<TextView>(R.id.post_date)
    }

    fun bindItem(userPost: UserPostResponse){
        userPost.apply {
            postTitle.text = title
            postPrice.text = price
            postDate.text = date
        }
        itemView.setOnClickListener {
            openPost(userPost)
        }
    }
}