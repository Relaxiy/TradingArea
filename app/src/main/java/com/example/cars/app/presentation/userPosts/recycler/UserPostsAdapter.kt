package com.example.cars.app.presentation.userPosts.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cars.app.domain.models.UserPost
import com.example.cars.app.domain.models.UserPostResponse

class UserPostsAdapter(
    private val openPost: (userPostResponse: UserPostResponse)-> Unit
) : RecyclerView.Adapter<UserPostsViewHolder>() {
    private var items = listOf<UserPostResponse>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserPostsViewHolder {
        return UserPostsViewHolder.newInstance(parent, openPost)
    }

    override fun onBindViewHolder(holder: UserPostsViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount() = items.size

    fun setItems(data: List<UserPostResponse>){
        items = data
        notifyDataSetChanged()
    }
}