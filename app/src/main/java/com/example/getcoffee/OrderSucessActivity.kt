package com.example.getcoffee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class OrderSucessActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_cart)
    }

    fun onTrackMyOrderClicked(view: View) {
        finish()

    }
}