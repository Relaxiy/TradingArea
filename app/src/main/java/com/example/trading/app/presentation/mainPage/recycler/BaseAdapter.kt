package com.example.trading.app.presentation.mainPage.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trading.app.domain.models.mainPage.BaseItem
import com.example.trading.app.domain.models.mainPage.Date
import com.example.trading.app.domain.models.mainPage.Post
import com.example.trading.app.domain.models.userPosts.UserPostResponse
import com.example.trading.app.presentation.mainPage.recycler.viewHolders.DateViewHolder
import com.example.trading.app.presentation.mainPage.recycler.viewHolders.PostViewHolder
import com.example.trading.app.presentation.mainPage.recycler.viewHolders.UserPostViewHolder

class BaseAdapter(
    private val userId: String,
    private val openPost: (id: Int, post: BaseItem) -> Unit
) : RecyclerView.Adapter<BaseViewHolder>() {

    private var items = listOf<BaseItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            DateViewHolder.VIEW_TYPE -> DateViewHolder.newInstance(parent)
            PostViewHolder.VIEW_TYPE -> PostViewHolder.newInstance(parent, openPost)
            UserPostViewHolder.VIEW_TYPE -> UserPostViewHolder.newInstance(parent, openPost)
            else -> throw IllegalStateException("Wrong ViewHolder type")
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is Date -> DateViewHolder.VIEW_TYPE
            is Post -> PostViewHolder.VIEW_TYPE
            is UserPostResponse -> UserPostViewHolder.VIEW_TYPE
            else -> 0
        }
    }

    fun setItems(data: List<BaseItem>) {
        items = data
        notifyDataSetChanged()
    }
}