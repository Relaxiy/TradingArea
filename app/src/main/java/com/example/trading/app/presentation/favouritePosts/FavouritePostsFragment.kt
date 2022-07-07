package com.example.trading.app.presentation.favouritePosts

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.trading.R
import com.example.trading.databinding.FragmentFavouritePostsBinding
import com.example.trading.utils.ext.mainActivityComponent
import com.example.trading.utils.sharedPrefs.SharedPreferencesManager
import javax.inject.Inject

class FavouritePostsFragment : Fragment(R.layout.fragment_favourite_posts) {

    companion object {
        const val TAG = "FavouriteCarsFragment"
        fun newInstance() = FavouritePostsFragment()
    }

    private val favouritePostsFragmentViewModel: FavouritePostsFragmentViewModel by viewModels {
        requireActivity().mainActivityComponent.viewModelsFactory()
    }

    @Inject
    lateinit var sharedPreferencesManager: SharedPreferencesManager

    private val binding: FragmentFavouritePostsBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().mainActivityComponent.inject(this)
        binding.progressLoad.visibility = ProgressBar.VISIBLE
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun initFavourites(){
        favouritePostsFragmentViewModel.loadFavourites(sharedPreferencesManager.getDocumentPath())
        binding.progressLoad.visibility = ProgressBar.INVISIBLE
        favouritePostsFragmentViewModel.favouritePosts.observe(viewLifecycleOwner){

        }
    }
}