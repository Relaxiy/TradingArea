package com.example.trading.app.presentation.chatsPage.messages

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.trading.R
import com.example.trading.TradingApplication
import com.example.trading.app.presentation.mainPage.PostItemSharedViewModel
import com.example.trading.app.presentation.personalPage.UserSharedViewModel
import com.example.trading.databinding.ChatItemBinding
import com.example.trading.utils.ext.mainActivityComponent
import javax.inject.Inject

class MessagesFragment : Fragment(R.layout.chat_item) {
    companion object{
        const val TAG = "MessagesFragment"
        fun newInstance() = MessagesFragment()
    }

    @Inject
    lateinit var postItemSharedViewModel: PostItemSharedViewModel

    private val binding: ChatItemBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().mainActivityComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUser()
    }

    private fun initUser(){
        postItemSharedViewModel.postItem.observe(viewLifecycleOwner){ post ->
            binding.name.text = post.username
        }
    }

}