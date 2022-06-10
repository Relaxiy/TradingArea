package com.example.cars.app.presentation.favouritePosts

import androidx.lifecycle.ViewModel
import com.example.cars.app.domain.interactors.favouritePostsInteractor.FavouritePostsInteractor
import javax.inject.Inject

class FavouritePostsFragmentViewModel @Inject constructor(
    private val favouritePostsInteractor: FavouritePostsInteractor
) : ViewModel() {


}