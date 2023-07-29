package com.example.getcoffee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.getcoffee.Adapters.CartItemsAdapter
import com.example.getcoffee.Model.CoffeeItem

class MyCartActivity: AppCompatActivity() {
    // Stores list of item in cart for use in recycler view
    var cartItems = mutableListOf<CoffeeItem>()
    var cartAdapter = CartItemsAdapter(cartItems)
    var cartRecyclerView: RecyclerView? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_cart)

        // Get recycler view
        cartRecyclerView = findViewById(R.id.recyclerMyCart)
        // Set adapter
        cartRecyclerView?.adapter = cartAdapter



    }

    fun onBackButtonClicked(view: View) {
        finish()
    }
}