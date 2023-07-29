package com.example.getcoffee.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.getcoffee.Model.CoffeeItem
import com.example.getcoffee.R

class featuredItemsAdapter(private val foodList: List<CoffeeItem>) : RecyclerView.Adapter<featuredItemsAdapter.ViewHolder>() {
    var coffeeList: ArrayList<CoffeeItem>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_coffee_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return coffeeList!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tmpcoffee = coffeeList!![position]
        holder.coffeeImage?.setImageResource(tmpcoffee.image!!)
        holder.coffeeName?.text = tmpcoffee.name

    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var coffeeImage: ImageView? = itemView.findViewById(R.id.imageCoffee)
        var coffeeName: TextView? = itemView.findViewById(R.id.txtCoffee)
    }

}