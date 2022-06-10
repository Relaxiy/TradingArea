package com.example.trading.app.presentation.chatsPage.messages.recycler.viewHolders

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.trading.R
import com.example.trading.app.presentation.chatsPage.messages.recycler.BaseViewHolder
import com.example.trading.databinding.IncomingMessageItemBinding

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