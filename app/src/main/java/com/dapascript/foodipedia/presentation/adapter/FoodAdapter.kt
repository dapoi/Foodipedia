package com.dapascript.foodipedia.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dapascript.foodipedia.data.source.model.ListFood
import com.dapascript.foodipedia.databinding.ItemFoodBinding

class FoodAdapter(
    private var onClick: ((ListFood) -> Unit)? = null
) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    private var getListFood = ArrayList<ListFood?>()

    fun setListFood(listFood: List<ListFood?>) {
        getListFood.clear()
        getListFood.addAll(listFood)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        return FoodViewHolder(
            ItemFoodBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = getListFood[position]
        if (food != null) {
            holder.bind(food)
        }
    }

    override fun getItemCount(): Int = getListFood.size

    inner class FoodViewHolder(
        private val binding: ItemFoodBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ListFood) {
            binding.apply {
                Glide.with(itemView.context)
                    .load(item.strMealThumb)
                    .into(ivFood)

                tvFoodName.text = item.strMeal
            }
        }

        init {
            binding.root.setOnClickListener {
                onClick?.invoke(getListFood[adapterPosition]!!)
            }
        }
    }
}