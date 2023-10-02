package com.dapascript.foodipedia.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dapascript.foodipedia.data.source.model.CategoriesItem
import com.dapascript.foodipedia.databinding.ItemCategoryBinding

class CategoriesAdapter(
    private val onClick: (CategoriesItem) -> Unit
) : ListAdapter<CategoriesItem, CategoriesAdapter.CategoryViewHolder>(CategoriesAdapter) {

    private var unfilteredList = listOf<CategoriesItem?>()

    fun customList(list: List<CategoriesItem?>) {
        unfilteredList = list
        submitList(list)
    }

    fun filterList(query: CharSequence?) {
        val list = mutableListOf<CategoriesItem?>()
        if (query != null) {
            unfilteredList.filter { item ->
                item?.strCategory?.contains(query, true) == true
            }.forEach {
                list.add(it)
            }

            submitList(list)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            ItemCategoryBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class CategoryViewHolder(
        private val binding: ItemCategoryBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CategoriesItem) {
            binding.apply {
                Glide.with(itemView).load(item.strCategoryThumb).into(ivFood)

                tvFood.text = item.strCategory
            }
        }

        init {
            binding.root.setOnClickListener {
                onClick(getItem(adapterPosition))
            }
        }
    }

    companion object : DiffUtil.ItemCallback<CategoriesItem>() {
        override fun areItemsTheSame(oldItem: CategoriesItem, newItem: CategoriesItem): Boolean {
            return oldItem.idCategory == newItem.idCategory
        }

        override fun areContentsTheSame(oldItem: CategoriesItem, newItem: CategoriesItem): Boolean {
            return oldItem == newItem
        }
    }
}