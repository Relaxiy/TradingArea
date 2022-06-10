package com.example.trading.app.presentation.userPosts.userPost

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.trading.R
import com.example.trading.app.presentation.userPosts.UserPostsFragment
import com.example.trading.app.presentation.userPosts.userPost.actionSelector.DeletePostResult
import com.example.trading.databinding.FragmentUserPostItemBinding
import com.example.trading.utils.ext.mainActivityComponent
import com.example.trading.utils.ext.openFragment
import javax.inject.Inject

class UserPostItemFragment : Fragment(R.layout.fragment_user_post_item) {
    companion object{
        const val TAG = "UserPostItemFragment"
        fun newInstance() = UserPostItemFragment()
    }

    @Inject
    lateinit var userPostItemSharedViewModel: UserPostItemSharedViewModel

    private val userPostItemFragmentViewModel: UserPostItemFragmentViewModel by viewModels {
        requireActivity().mainActivityComponent.viewModelsFactory()
    }

    private val binding: FragmentUserPostItemBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().mainActivityComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initInterface()
        deletePost()
    }

    private fun initInterface(){
        userPostItemSharedViewModel.postItem.observe(viewLifecycleOwner){ userPostResponse ->
            binding.hola.text = userPostResponse.date
            userPostItemFragmentViewModel.saveData(userPostResponse)
        }
    }

    private fun deletePost(){
        binding.deletePost.setOnClickListener {
            binding.progressDeletePost.visibility = ProgressBar.VISIBLE
            userPostItemFragmentViewModel.deletePost()
        }

        userPostItemFragmentViewModel.deleteResult.observe(viewLifecycleOwner){ deletePostResult ->
            when(deletePostResult) {
                is DeletePostResult.SuccessResult -> {
                    Toast.makeText(requireContext(), deletePostResult.success, Toast.LENGTH_LONG).show()
                    requireActivity().openFragment(
                        UserPostsFragment.newInstance(),
                        UserPostsFragment.TAG,
                        R.id.container
                    )
                }
            }
        }
    }

}