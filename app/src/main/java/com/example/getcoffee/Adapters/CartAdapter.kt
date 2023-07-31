package com.example.getcoffee.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.getcoffee.Model.CoffeeItem
import com.example.getcoffee.R

class CartItemsAdapter(private var cartItems: List<CoffeeItem>) : RecyclerView.Adapter<CartItemsAdapter.CartItemsViewHolder>() {
    val cartList: ArrayList<CoffeeItem>? = cartItems as ArrayList<CoffeeItem>?

    class CartItemsViewHolder (view:View): RecyclerView.ViewHolder(view) {
        var nameView: TextView? = view.findViewById(R.id.txtCoffeeName)
        var priceView: TextView? = view.findViewById(R.id.txtPrice)
        var descView: TextView? = view.findViewById(R.id.txtDesc)
        var quantityView: TextView? = view.findViewById(R.id.txtXCounter)
        var imageView: ImageView? = view.findViewById(R.id.imageCoffee)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartItemsViewHolder {
        return if (cartList!!.isEmpty())
            CartItemsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_empty_item, parent, false))
        else
            CartItemsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_cart_item, parent, false))
    }

    override fun getItemCount(): Int {
        return cartList!!.size
    }

    override fun onBindViewHolder(holder: CartItemsViewHolder, position: Int) {
        holder.imageView?.setImageResource(cartList!![position].image!!)
        holder.nameView?.text = cartList!![position].name

        holder.priceView?.text = "$ " + "%.2f".format(cartList!![position].get_totalPrice())
        holder.descView?.text = cartList[position].get_description()
        holder.quantityView?.text = "x" + cartList!![position].quantity.toString()
    }
}