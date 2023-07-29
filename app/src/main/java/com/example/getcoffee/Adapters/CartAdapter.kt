package com.example.getcoffee.Adapters

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.getcoffee.Model.CoffeeItem

class CartItemsAdapter(private var cartItems: List<CoffeeItem>) : RecyclerView.Adapter<CartItemsAdapter.CartItemsViewHolder>() {
    class CartItemsViewHolder (view:View): RecyclerView.ViewHolder(view) {
        var name: TextView? = null
        var price: TextView? = null
        var quantity: TextView? = null
        var size: TextView? = null
        var temperature: TextView? = null
        var ice: TextView? = null
        var coffee: TextView? = null

        var img: ImageView? = null
        var remove: ImageView? = null

        public fun CardItemsViewholder(view: View) {
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartItemsViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CartItemsViewHolder, position: Int) {
        TODO("Not yet implemented")
    }


}