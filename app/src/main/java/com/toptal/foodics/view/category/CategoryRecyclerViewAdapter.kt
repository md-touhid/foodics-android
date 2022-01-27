package com.toptal.foodics.view.category

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.toptal.foodics.data.database.model.Category
import com.toptal.foodics.databinding.ItemCategoryBinding

class CategoryRecyclerViewAdapter(
    private val values: List<Category>,
    private val onClick: (item: Category) -> Unit
) : RecyclerView.Adapter<CategoryRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            ItemCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.name
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber
        private val cardView: CardView = binding.card

        init {
            cardView.setOnClickListener {
                onClick(values[absoluteAdapterPosition])
            }
        }
    }

}