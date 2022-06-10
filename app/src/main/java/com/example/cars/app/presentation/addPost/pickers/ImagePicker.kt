package com.example.cars.app.presentation.addPost.pickers

import android.net.Uri
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContracts

class ImagePicker(
    private val activityResultRegistry: ActivityResultRegistry,
    private val callback: (imageUri: Uri?) -> Unit
) {
    companion object{
        const val TAG = "ImagePicker"

    }

    private val getContent = activityResultRegistry.register(TAG, ActivityResultContracts.GetContent(), callback)

    fun pickImage(){
        getContent.launch("image/*")
    }
}