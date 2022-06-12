package com.example.trading.app.presentation.addPost.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.result.ActivityResultRegistry
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.trading.R
import com.example.trading.app.presentation.addPost.pickers.ImagePicker
import com.example.trading.databinding.ImageItemBinding

class HorizontalImageViewHolder(
    private val binding: ImageItemBinding,
    activityResultRegistry: ActivityResultRegistry
) : RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun newInstance(parent: ViewGroup, activityResultRegistry: ActivityResultRegistry) =
            HorizontalImageViewHolder(
                ImageItemBinding.bind(
                    LayoutInflater.from(parent.context)
                        .inflate(
                            R.layout.image_item,
                            parent,
                            false
                        ),
                ),
                activityResultRegistry
            )
    }

    private val imagePicker = ImagePicker(activityResultRegistry) {
        binding.addImage.load(it)
    }

    fun bindItem() {
        binding.addImage.setOnClickListener {
            imagePicker.pickImage()

        }
    }
}