package com.example.trading.app.presentation.favouritePosts

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.trading.R
import com.example.trading.databinding.FragmentFavouritePostsBinding
import com.example.trading.utils.ext.mainActivityComponent

class FavouritePostsFragment : Fragment(R.layout.fragment_favourite_posts) {

    companion object {
        const val TAG = "FavouriteCarsFragment"
        fun newInstance() = FavouritePostsFragment()
    }

    private val favouritePostsFragmentViewModel: FavouritePostsFragmentViewModel by viewModels {
        requireActivity().mainActivityComponent.viewModelsFactory()
    }

    private val binding: FragmentFavouritePostsBinding by viewBinding()

}