package com.example.trading.app.presentation

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import com.example.trading.R
import com.example.trading.app.presentation.addPost.AddPostFragment
import com.example.trading.app.presentation.chatsPage.ChatsFragment
import com.example.trading.app.presentation.favouritePosts.FavouritePostsFragment
import com.example.trading.app.presentation.mainPage.MainPageFragment
import com.example.trading.app.presentation.personalPage.PersonalPageFragment
import com.example.trading.databinding.ActivityMainBinding
import com.example.trading.utils.ext.openFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import javax.inject.Inject

class MainActivityViewModel @Inject constructor() : ViewModel() {

    fun initBottomNavMenu(
        binding: ActivityMainBinding,
        bottomNav: BottomNavigationView,
        mainActivity: FragmentActivity
    ) {
        binding.apply {

            bottomNav.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.posts -> {
                        mainActivity.openFragment(
                            MainPageFragment.newInstance(),
                            MainPageFragment.TAG,
                            R.id.container
                        )
                    }
                    R.id.messages -> {
                        mainActivity.openFragment(
                            ChatsFragment.newInstance(),
                            ChatsFragment.TAG,
                            R.id.container
                        )
                    }
                    R.id.add_post_button -> {
                        mainActivity.openFragment(
                            AddPostFragment.newInstance(),
                            AddPostFragment.TAG,
                            R.id.container
                        )
                    }
                    R.id.favourites_button -> {
                        mainActivity.openFragment(
                            FavouritePostsFragment.newInstance(),
                            FavouritePostsFragment.TAG,
                            R.id.container
                        )
                    }
                    R.id.home -> {
                        mainActivity.openFragment(
                            PersonalPageFragment.newInstance(),
                            PersonalPageFragment.TAG,
                            R.id.container
                        )
                    }
                }
                true
            }
        }
    }
}