package com.example.trading.app.presentation.mainPage.recycler.viewHolders

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trading.R
import com.example.trading.app.domain.models.mainPage.BaseItem
import com.example.trading.app.domain.models.mainPage.Post
import com.example.trading.app.presentation.mainPage.recycler.BaseViewHolder
import com.example.trading.databinding.PostItemBinding
import com.example.trading.utils.ext.toDate

class PostViewHolder(
    private val binding: PostItemBinding,
    private val openPost: (id: Int, post: BaseItem) -> Unit
) : BaseViewHolder(binding.root) {
    companion object {
        const val VIEW_TYPE = 2
        fun newInstance(
            parent: ViewGroup,
            openPost: (id: Int, post: BaseItem) -> Unit
        ) = PostViewHolder(
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

    override fun bindItem(baseItem: BaseItem) {
        (baseItem as Post).apply {
            binding.postPrice.text = price
            binding.postTitle.text = title
            binding.postDate.text = date.toDate()
        }

        binding.postItem.setOnClickListener {
            openPost(VIEW_TYPE, baseItem)
        }
    }

}