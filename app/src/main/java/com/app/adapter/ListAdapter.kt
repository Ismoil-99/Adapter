package com.app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.adapter.data.PizzaModel

class ListAdapter(private val pizza : List<PizzaModel>) : RecyclerView.Adapter<ListAdapter.WordsViewHolder>() {
    inner class WordsViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val name_word = view.findViewById<TextView>(R.id.namePizza)
        val description = view.findViewById<TextView>(R.id.description)
        val bigPizzaPrice = view.findViewById<TextView>(R.id.bigPizzaPrice)
        val smallPizzaPrice = view.findViewById<TextView>(R.id.smallPizzaPrice)
        val mediumPizzaPrice = view.findViewById<TextView>(R.id.mediumPizzaPrice)
        val imagePizza = view.findViewById<ImageView>(R.id.pizzaFoto)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordsViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.list_words, parent, false)
        return WordsViewHolder(layout)
    }
    override fun onBindViewHolder(holder: WordsViewHolder, position: Int) {
        val item = pizza[position]
        holder.name_word.text = item.namePizza
        holder.bigPizzaPrice.text = item.bigPizzaPrice.toString()+"см"
        holder.mediumPizzaPrice.text = item.mediumPizzaPrice.toString()+"см"
        holder.smallPizzaPrice.text = item.smallPizzaPrice.toString()+"см"
        holder.description.text = item.description
        holder.imagePizza.setImageResource(pizza[position].imagePizza)
    }
    override fun getItemCount() = pizza.size
}