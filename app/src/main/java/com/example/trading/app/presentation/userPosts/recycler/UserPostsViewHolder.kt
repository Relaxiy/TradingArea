package com.example.trading.app.presentation.userPosts.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.trading.R
import com.example.trading.app.domain.models.userPosts.UserPostResponse
import com.example.trading.databinding.PostItemBinding
import com.example.trading.utils.ext.toDate

class UserPostsViewHolder(
    private val binding: PostItemBinding,
    private val openPost: (userPostResponse: UserPostResponse) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun newInstance(
            parent: ViewGroup,
            openPost: (userPostResponse: UserPostResponse) -> Unit
        ) = UserPostsViewHolder(
            PostItemBinding.bind(
                LayoutInflater.from(parent.context)
                    .inflate(
                        R.layout.post_item,
                        parent,
                        false
                    )
            ),
            openPost
        )
    }

    fun bindItem(userPost: UserPostResponse) {
        binding.favourite.visibility = ImageView.INVISIBLE
        userPost.apply {
            binding.postTitle.text = title
            binding.postPrice.text = price
            binding.postDate.text = date.toDate()
        }
        itemView.setOnClickListener {
            openPost(userPost)
        }
    }
}