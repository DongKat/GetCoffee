package com.example.getcoffee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.getcoffee.Adapters.CartItemsAdapter
import com.example.getcoffee.Model.CoffeeItem
import androidx.recyclerview.widget.ItemTouchHelper

class MyCartActivity: AppCompatActivity() {

    var cartItems: MutableList<CoffeeItem>? = null
    var totalCartPrice: Double? = 0.00

    var cartRecyclerView: RecyclerView? = null
    var cartPrice: TextView? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_cart)

        // Get recycler view
        cartRecyclerView = findViewById(R.id.recyclerMyCart)
        cartPrice = findViewById(R.id.txtTotalPrice)

        cartItems = mutableListOf<CoffeeItem>()
        cartItems!!.add(CoffeeItem("Americano", R.drawable.img_americano, "N/A", 2, 3.00, 12, 1, 1, 1, 2))
        cartItems!!.add(CoffeeItem("Cappuccino", R.drawable.img_cappuccino, "N/A", 1, 3.00, 12, 1, 1, 1, 2))

        // Set adapter
        setCartRecyclerView()


        // Get total cart price
        for (item in cartItems!!) {
            totalCartPrice = totalCartPrice?.plus(item.get_totalPrice())
        }
        cartPrice?.text = "$" + "%.2f".format(totalCartPrice)



    }

    private fun setCartRecyclerView() {

        val cartAdapter = CartItemsAdapter(cartItems!!)
        val layoutManager = LinearLayoutManager(this)
        cartRecyclerView?.layoutManager = layoutManager
        cartRecyclerView?.adapter = cartAdapter

    }

    fun onBackButtonClicked(view: View) {
        finish()
    }

    fun onDeleteButtonClicked(view: View) {
        // Get position of item to delete
        val position = view.tag as Int
        // Remove item from list
        cartItems!!.removeAt(position)
        // Update recycler view
        cartRecyclerView?.adapter?.notifyItemRemoved(position)
        // Update total price
        totalCartPrice = 0.00
        for (item in cartItems!!) {
            totalCartPrice = totalCartPrice?.plus(item.get_totalPrice())
        }
        cartPrice?.text = "$" + "%.2f".format(totalCartPrice)
    }
}