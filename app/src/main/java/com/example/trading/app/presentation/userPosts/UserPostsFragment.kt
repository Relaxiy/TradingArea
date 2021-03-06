package com.example.trading.app.presentation.userPosts

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.trading.R
import com.example.trading.app.domain.models.userPosts.UserPostResponse
import com.example.trading.app.presentation.addPost.AddPostFragment
import com.example.trading.app.presentation.userPosts.actionSelector.GetPostsResult.*
import com.example.trading.app.presentation.userPosts.recycler.UserPostsAdapter
import com.example.trading.app.presentation.userPosts.userPost.UserPostItemFragment
import com.example.trading.app.presentation.mainPage.PostItemSharedViewModel
import com.example.trading.databinding.FragmentUserPostsBinding
import com.example.trading.utils.ext.mainActivityComponent
import com.example.trading.utils.ext.openFragment
import com.example.trading.utils.sharedPrefs.SharedPreferencesManager
import kotlinx.android.synthetic.main.fragment_user_posts.*
import javax.inject.Inject

class UserPostsFragment : Fragment(R.layout.fragment_user_posts) {

    companion object {
        const val TAG = "UserPostsFragment"
        fun newInstance() = UserPostsFragment()
    }

    @Inject
    lateinit var sharedPreferences: SharedPreferencesManager

    @Inject
    lateinit var postItemSharedViewModel: PostItemSharedViewModel

    private val binding: FragmentUserPostsBinding by viewBinding()

    private val userPostsFragmentViewModel by viewModels<UserPostsFragmentViewModel> {
        requireActivity().mainActivityComponent.viewModelsFactory()
    }

    private val adapter by lazy {
        UserPostsAdapter { userPostResponse ->
            openPost(userPostResponse)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().mainActivityComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUserPosts()
        observePostsResultFromServer()
        addPost()
    }

    private fun openPost(userPostResponse: UserPostResponse) {
        postItemSharedViewModel.addUserPostOnInterface(userPostResponse)
        requireActivity().openFragment(
            UserPostItemFragment.newInstance(),
            UserPostItemFragment.TAG,
            R.id.container
        )
    }

    private fun initUserPosts() {
        progressUserPosts.visibility = ProgressBar.VISIBLE
        userPostsFragmentViewModel.getUserPosts(sharedPreferences.getDocumentPath())
        userPostsFragmentViewModel.synchronizePosts(sharedPreferences.getDocumentPath())
        binding.recyclerUserPosts.adapter = adapter

        userPostsFragmentViewModel.userPosts.observe(viewLifecycleOwner) { userPosts ->
            binding.progressUserPosts.visibility = ProgressBar.INVISIBLE
            adapter.setItems(userPosts)
        }
    }

    private fun observePostsResultFromServer() {
        userPostsFragmentViewModel.getPostsResult.observe(viewLifecycleOwner) { getPostsResult ->
            when (getPostsResult) {
                is EmptyPostsResult -> {
                    binding.imageAddUserPost.visibility = ImageView.VISIBLE
                    binding.progressUserPosts.visibility = ProgressBar.INVISIBLE
                }
                is SuccessResult -> {
                    userPostsFragmentViewModel.saveUserPostsInRoom(
                        getPostsResult.success,
                        sharedPreferences.getDocumentPath()
                    )
                }
            }
        }
    }

    private fun addPost(){
        binding.imageAddUserPost.setOnClickListener {
            requireActivity().openFragment(
                AddPostFragment.newInstance(),
                AddPostFragment.TAG,
                R.id.container
            )
        }
    }
}