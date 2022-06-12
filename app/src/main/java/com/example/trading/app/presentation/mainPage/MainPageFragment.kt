package com.example.trading.app.presentation.mainPage

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.trading.R
import com.example.trading.app.domain.models.mainPage.BaseItem
import com.example.trading.app.domain.models.mainPage.Post
import com.example.trading.app.domain.models.userPosts.UserPostResponse
import com.example.trading.app.presentation.mainPage.posts.PostItemFragment
import com.example.trading.app.presentation.mainPage.recycler.BaseAdapter
import com.example.trading.app.presentation.mainPage.recycler.viewHolders.PostViewHolder
import com.example.trading.app.presentation.mainPage.recycler.viewHolders.UserPostViewHolder
import com.example.trading.app.presentation.userPosts.userPost.UserPostItemFragment
import com.example.trading.databinding.FragmentMainPageBinding
import com.example.trading.utils.ext.mainActivityComponent
import com.example.trading.utils.ext.openFragment
import com.example.trading.utils.sharedPrefs.SharedPreferencesManager
import kotlinx.android.synthetic.main.fragment_main_page.*
import javax.inject.Inject

class MainPageFragment : Fragment(R.layout.fragment_main_page) {

    companion object {
        const val TAG = "HomeFragment"
        fun newInstance() = MainPageFragment()
    }

    @Inject
    lateinit var sharedPreferences: SharedPreferencesManager

    @Inject
    lateinit var postItemSharedViewModel: PostItemSharedViewModel

    private val mainPageFragmentViewModel: MainPageFragmentViewModel by viewModels {
        requireActivity().mainActivityComponent.viewModelsFactory()
    }

    private val binding: FragmentMainPageBinding by viewBinding()

    private val adapter by lazy {
        BaseAdapter(sharedPreferences.getDocumentPath()) { id, post ->
            openPost(id, post)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().mainActivityComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
    }

    private fun openPost(id: Int, post: BaseItem) {
        when (id) {
            PostViewHolder.VIEW_TYPE -> {
                postItemSharedViewModel.addPostOnInterface(post as Post)
                requireActivity().openFragment(
                    PostItemFragment.newInstance(),
                    PostItemFragment.TAG,
                    R.id.container
                )
            }
            UserPostViewHolder.VIEW_TYPE -> {
                postItemSharedViewModel.addUserPostOnInterface(post as UserPostResponse)
                requireActivity().openFragment(
                    UserPostItemFragment.newInstance(),
                    UserPostItemFragment.TAG,
                    R.id.container
                )
            }
        }
    }

    private fun initRecycler() {
        binding.mainRecycler.adapter = adapter
        mainPageFragmentViewModel.loadPosts(sharedPreferences.getDocumentPath())
        mainPageFragmentViewModel.posts.observe(viewLifecycleOwner) { posts ->
            progress.visibility = ProgressBar.INVISIBLE
            adapter.setItems(posts)
        }
    }

}