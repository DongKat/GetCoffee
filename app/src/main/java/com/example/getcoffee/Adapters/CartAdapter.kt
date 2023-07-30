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
        var nameView: TextView? = view.findViewById(R.id.txtCoffee)
        var priceView: TextView? = view.findViewById(R.id.txtPrice)
        var descView: TextView? = view.findViewById(R.id.txtDesc)
        var quantityView: TextView? = view.findViewById(R.id.txtXCounter)
        var imageView: ImageView? = view.findViewById(R.id.imageCoffee)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartItemsViewHolder {
        if (cartList!!.isEmpty())
            return CartItemsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_empty_item, parent, false))
        else
            return CartItemsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_cart_item, parent, false))
    }

    override fun getItemCount(): Int {
        return cartList!!.size
    }

    override fun onBindViewHolder(holder: CartItemsViewHolder, position: Int) {
        holder.nameView?.text = cartList!![position].name

        val tmpprice = cartList[position].get_totalPrice()
        holder.priceView?.text = "$" + "%.2f".format(tmpprice)
        val tmptxt = cartList[position].get_coffeeShot() + '|' +
                cartList[position].get_size() + '|' +
                cartList[position].get_temperature() + '|' +
                cartList[position].get_ice()
        holder.descView?.text = tmptxt
        holder.quantityView?.text = "x" + cartList!![position].quantity.toString()
    }
}