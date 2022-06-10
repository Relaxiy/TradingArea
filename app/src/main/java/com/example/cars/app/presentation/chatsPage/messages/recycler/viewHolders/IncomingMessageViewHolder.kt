package com.example.cars.app.presentation.chatsPage.messages.recycler.viewHolders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cars.R
import com.example.cars.app.presentation.chatsPage.messages.recycler.BaseViewHolder
import com.example.cars.databinding.IncomingMessageItemBinding

class IncomingMessageViewHolder(private val binding: IncomingMessageItemBinding) :
    BaseViewHolder(binding.root) {
    companion object {
        const val VIEW_TYPE = 1
        fun newInstance(parent: ViewGroup) = IncomingMessageViewHolder(
            IncomingMessageItemBinding.bind(
                LayoutInflater.from(
                    parent.context
                ).inflate(
                    R.layout.incoming_message_item,
                    parent,
                    false
                )
            )
        )
    }

    override fun bindItem() {

    }
}