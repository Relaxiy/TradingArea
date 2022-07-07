package com.example.trading.app.presentation.favouritePosts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trading.app.domain.interactors.favouritePostsInteractor.FavouritePostsInteractor
import com.example.trading.app.domain.models.favourites.FavouritePost
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavouritePostsFragmentViewModel @Inject constructor(
    private val favouritePostsInteractor: FavouritePostsInteractor
) : ViewModel() {

    val favouritePosts: LiveData<List<FavouritePost>> get() = _favouritePosts
    private val _favouritePosts = MutableLiveData<List<FavouritePost>>()

    fun loadFavourites(loggedUserId: String){
        viewModelScope.launch {
            _favouritePosts.postValue(favouritePostsInteractor.getFavouritePosts(loggedUserId))
        }
    }

}