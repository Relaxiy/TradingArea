package com.example.cars.app.presentation.mainPage.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cars.app.domain.models.Post

class PostAdapter : RecyclerView.Adapter<PostViewHolder>() {

    private var items: List<Post> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder.newInstance(parent)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun setItems(data: List<Post>) {
        items = data
        notifyDataSetChanged()
    }
}