package com.app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.adapter.data.Food

class ListAdapter: RecyclerView.Adapter<ListAdapter.ProductsViewHolder>() {

    private var listNewFood:List<Food> = emptyList()

    fun submitList(food: List<Food>) {
        listNewFood = food
        notifyDataSetChanged()
    }
    var onItemClick: ((Food) -> Unit)? = null
    inner class ProductsViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val name_product = view.findViewById<TextView>(R.id.productsName)
        val description_products = view.findViewById<TextView>(R.id.description)
        val image_products = view.findViewById<ImageView>(R.id.pizzaFoto)
        val price_products = view.findViewById<TextView>(R.id.priceFood)
        init {
            view.setOnClickListener {
                onItemClick?.invoke(listNewFood[adapterPosition])
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.list_words, parent, false)
        return ProductsViewHolder(layout)
    }
    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        val item = listNewFood[position]
        holder.name_product.text = item.name
        holder.description_products.text = item.description
        holder.image_products.setImageResource(listNewFood[position].imageId)
        holder.price_products.text = "${item.price} TJS"
    }
    override fun getItemCount() = listNewFood.size
}