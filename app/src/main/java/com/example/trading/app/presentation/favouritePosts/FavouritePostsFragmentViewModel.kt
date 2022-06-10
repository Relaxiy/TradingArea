package com.example.trading.app.presentation.favouritePosts

import androidx.lifecycle.ViewModel
import com.example.trading.app.domain.interactors.favouritePostsInteractor.FavouritePostsInteractor
import javax.inject.Inject

class FavouritePostsFragmentViewModel @Inject constructor(
    private val favouritePostsInteractor: FavouritePostsInteractor
) : ViewModel() {


}