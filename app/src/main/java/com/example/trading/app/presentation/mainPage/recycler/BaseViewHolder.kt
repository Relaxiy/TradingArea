package com.example.trading.app.presentation.mainPage.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.trading.app.domain.models.mainPage.BaseItem

abstract class BaseViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {

    abstract fun bindItem(baseItem: BaseItem)
}