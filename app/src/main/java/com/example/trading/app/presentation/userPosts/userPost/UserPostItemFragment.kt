package com.example.trading.app.presentation.userPosts.userPost

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.trading.R
import com.example.trading.app.presentation.mainPage.PostItemSharedViewModel
import com.example.trading.app.presentation.userPosts.UserPostsFragment
import com.example.trading.app.presentation.userPosts.userPost.actionSelector.DeletePostResult
import com.example.trading.databinding.FragmentUserPostItemBinding
import com.example.trading.utils.ext.mainActivityComponent
import com.example.trading.utils.ext.openFragment
import com.example.trading.utils.ext.toDate
import com.google.android.material.button.MaterialButton
import javax.inject.Inject

class UserPostItemFragment : Fragment(R.layout.fragment_user_post_item) {
    companion object {
        const val TAG = "UserPostItemFragment"
        fun newInstance() = UserPostItemFragment()
    }

    @Inject
    lateinit var postItemSharedViewModel: PostItemSharedViewModel

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

    private fun initInterface() {
        postItemSharedViewModel.userPostItem.observe(viewLifecycleOwner) { userPostResponse ->
            binding.postTitle.text = userPostResponse.title
            binding.postPrice.text = userPostResponse.price
            binding.postDescription.text = userPostResponse.description
            binding.postEmail.text = userPostResponse.email
            binding.postPhoneNumber.text = userPostResponse.phoneNumber
            binding.author.text = userPostResponse.username
            binding.date.text = userPostResponse.date.toDate()
            userPostItemFragmentViewModel.saveData(userPostResponse)
        }
    }

    private fun deletePost() {
        binding.deletePost.setOnClickListener {
            val dialog = Dialog(requireContext())
            dialog.setContentView(R.layout.custom_dialog_layout)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.show()
            dialog.findViewById<MaterialButton>(R.id.yes).setOnClickListener {
                binding.progressDeletePost.visibility = ProgressBar.VISIBLE
                dialog.hide()
                userPostItemFragmentViewModel.deletePost()
            }
            dialog.findViewById<MaterialButton>(R.id.no).setOnClickListener {
                dialog.hide()
            }
        }

        userPostItemFragmentViewModel.deleteResult.observe(viewLifecycleOwner) { deletePostResult ->
            when (deletePostResult) {
                is DeletePostResult.SuccessResult -> {
                    Toast.makeText(requireContext(), deletePostResult.success, Toast.LENGTH_LONG)
                        .show()
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