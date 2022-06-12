package com.example.trading.app.presentation.mainPage.posts

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.trading.R
import com.example.trading.app.presentation.favouritePosts.FavouritePostsFragment
import com.example.trading.app.presentation.mainPage.PostItemSharedViewModel
import com.example.trading.databinding.FragmentPostItemBinding
import com.example.trading.utils.ext.mainActivityComponent
import javax.inject.Inject

class PostItemFragment : Fragment(R.layout.fragment_post_item) {
    companion object {
        const val TAG = "PostItemFragment"
        fun newInstance() = PostItemFragment()
    }

    @Inject
    lateinit var postItemSharedViewModel: PostItemSharedViewModel

    private val binding: FragmentPostItemBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().mainActivityComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFields()
        sendEmail()
        savePhone()
    }

    private fun initFields() {
        postItemSharedViewModel.postItem.observe(viewLifecycleOwner) { post ->
            with(binding) {
                postTitle.text = post.title
                postPrice.text = post.price
                postDescription.text = post.description
                postEmail.text = post.email
                postPhoneNumber.text = post.phoneNumber
                author.text = post.username
                date.text = post.date
            }
        }
    }

    private fun savePhone(){
        binding.openPhoneNumber.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:" + binding.postPhoneNumber.text.toString())
            startActivity(intent)
        }
    }

    private fun sendEmail(){
        binding.sendEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("mailto:" + binding.postEmail.text.toString())
            startActivity(intent)
        }
    }
}