package com.example.cars.app.presentation.chatsPage

import androidx.fragment.app.Fragment
import com.example.cars.R

class ChatsFragment : Fragment(R.layout.fragment_chats) {
    companion object{
        const val TAG = "ChatsFragment"
        fun newInstance() = ChatsFragment()
    }
}