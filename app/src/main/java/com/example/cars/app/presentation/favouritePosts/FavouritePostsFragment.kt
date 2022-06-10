package com.example.cars.app.presentation.favouritePosts

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.cars.R
import com.example.cars.utils.ext.appComponent

class FavouritePostsFragment : Fragment(R.layout.fragment_favourite_posts) {

    companion object {
        const val TAG = "FavouriteCarsFragment"
        fun newInstance() = FavouritePostsFragment()
    }

    private val favouritePostsFragmentViewModel: FavouritePostsFragmentViewModel by viewModels {
        requireActivity().appComponent.viewModelsFactory()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}