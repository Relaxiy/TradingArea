package com.example.cars.app.presentation.addPost.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.activity.result.ActivityResultRegistry
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.cars.R
import com.example.cars.app.presentation.addPost.pickers.ImagePicker

class HorizontalImageViewHolder(
    itemView: View,
    activityResultRegistry: ActivityResultRegistry
) : RecyclerView.ViewHolder(itemView) {
    companion object {
        fun newInstance(parent: ViewGroup, activityResultRegistry: ActivityResultRegistry) =
            HorizontalImageViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(
                        R.layout.image_item,
                        parent,
                        false
                    ),
                activityResultRegistry
            )
    }

    private val imagePicker = ImagePicker(activityResultRegistry){
        addImage.load(it)
    }

    private val addImage by lazy {
        itemView.findViewById<ImageView>(R.id.add_image)
    }

    fun bindItem() {
        addImage.setOnClickListener {
            imagePicker.pickImage()
        }
    }
}