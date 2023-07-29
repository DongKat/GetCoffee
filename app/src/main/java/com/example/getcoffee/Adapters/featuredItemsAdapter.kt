package com.example.getcoffee.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.getcoffee.Model.CoffeeItem
import com.example.getcoffee.R

class featuredItemsAdapter(private val coffee: List<CoffeeItem>) : RecyclerView.Adapter<featuredItemsAdapter.featuredItemsViewHolder>() {
    var coffeeList: ArrayList<CoffeeItem>? = coffee as ArrayList<CoffeeItem>?


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): featuredItemsViewHolder {
        return featuredItemsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_featured_coffee, parent, false))
    }

    override fun getItemCount(): Int {
        return coffeeList!!.size
    }

    override fun onBindViewHolder(holder: featuredItemsViewHolder, position: Int) {
        holder.coffeeImage?.setImageResource(coffeeList!![position].image!!)
        holder.coffeeName?.text = coffeeList!![position].name

    }
    class featuredItemsViewHolder (view: View): RecyclerView.ViewHolder(view){
        var coffeeImage: ImageView? = view.findViewById(R.id.imageCoffee)
        var coffeeName: TextView? = view.findViewById(R.id.txtCoffee)
    }

}