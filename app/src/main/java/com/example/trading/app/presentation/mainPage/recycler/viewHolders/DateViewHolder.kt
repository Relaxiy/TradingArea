package com.example.trading.app.presentation.mainPage.recycler.viewHolders

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.trading.R
import com.example.trading.app.domain.models.mainPage.BaseItem
import com.example.trading.app.domain.models.mainPage.Date
import com.example.trading.app.presentation.mainPage.recycler.BaseViewHolder
import com.example.trading.databinding.DateItemBinding

class DateViewHolder(private val binding: DateItemBinding) : BaseViewHolder(binding.root) {
    companion object {
        const val VIEW_TYPE = 1
        fun newInstance(parent: ViewGroup) = DateViewHolder(
            DateItemBinding.bind(
                LayoutInflater.from(parent.context)
                    .inflate(
                        R.layout.date_item,
                        parent,
                        false
                    )
            )
        )
    }

    override fun bindItem(baseItem: BaseItem) {
        (baseItem as Date).apply {
            binding.date.text = date
        }
    }
}