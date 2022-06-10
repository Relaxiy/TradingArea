package com.example.cars.app.presentation.userPosts.userPost

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.cars.R
import com.example.cars.app.presentation.userPosts.UserPostsFragment
import com.example.cars.app.presentation.userPosts.userPost.actionSelector.DeletePostResult
import com.example.cars.databinding.FragmentUserPostItemBinding
import com.example.cars.utils.ext.mainActivityComponent
import com.example.cars.utils.ext.openFragment
import javax.inject.Inject

class UserPostItemFragment : Fragment(R.layout.fragment_user_post_item) {
    companion object{
        const val TAG = "UserPostItemFragment"
        fun newInstance() = UserPostItemFragment()
    }

    @Inject
    lateinit var userPostItemSharedViewModel: UserPostItemSharedViewModel

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
        }
    }

    private fun deletePost(){
        binding.deletePost.setOnClickListener {
            binding.progressDeletePost.visibility = ProgressBar.VISIBLE
            userPostItemSharedViewModel.deletePost(requireContext())
        }

        userPostItemSharedViewModel.deleteResult.observe(viewLifecycleOwner){ deletePostResult ->
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