package com.toptal.foodics.view.product

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.toptal.foodics.data.database.model.Product
import com.toptal.foodics.databinding.ItemProductBinding
import com.toptal.foodics.utils.Helper

class ProductRecyclerViewAdapter(
    private val values: List<Product>,
    private val onClick: (item: Product) -> Unit
) : RecyclerView.Adapter<ProductRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            ItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.name
        holder.price.text = item.price.toString()
        Helper.loadImage(holder.idView.context,item.image, holder.imageView)
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemName
        val imageView: ImageView = binding.itemImage
        val price: TextView = binding.itemPrice
        private val linearLayout: LinearLayout = binding.linearLayout

        init {
            linearLayout.setOnClickListener {
                onClick(values[absoluteAdapterPosition])
            }
        }
    }

}