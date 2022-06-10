package com.example.cars.app.presentation.chatsPage.messages.recycler.viewHolders

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.cars.R
import com.example.cars.app.presentation.chatsPage.messages.recycler.BaseViewHolder
import com.example.cars.databinding.OutgoingMessageItemBinding

class OutgoingMessageViewHolder(private val binding: OutgoingMessageItemBinding) :
    BaseViewHolder(binding.root) {
    companion object {
        const val VIEW_TYPE = 2
        fun newInstance(parent: ViewGroup) = OutgoingMessageViewHolder(
            OutgoingMessageItemBinding.bind(
                LayoutInflater.from(
                    parent.context
                ).inflate(
                    R.layout.outgoing_message_item,
                    parent,
                    false
                )
            )
        )
    }

    override fun bindItem() {

    }
}