package com.somenthingnice.testtask.features.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.somenthingnice.testtask.databinding.ItemHistoryBinding
import androidx.recyclerview.widget.RecyclerView
import com.somenthingnice.testtask.entity.hisoty.HistoryItem

class HistoryAdapter(
    private val onItemClick: (HistoryItem) -> Unit
) : ListAdapter<HistoryItem, HistoryAdapter.ViewHolder>(DiffUtilsCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = ViewHolder(ItemHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class ViewHolder(
        private val binding: ItemHistoryBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: HistoryItem) {
            binding.number.text = item.number.toString()
            binding.root.setOnClickListener {
                onItemClick(item)
            }
        }

    }

    object DiffUtilsCallback : DiffUtil.ItemCallback<HistoryItem>() {
        override fun areItemsTheSame(
            oldItem: HistoryItem,
            newItem: HistoryItem
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: HistoryItem,
            newItem: HistoryItem
        ) = oldItem == newItem


    }


}