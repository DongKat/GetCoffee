package com.example.getcoffee.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import com.example.getcoffee.R

class OrderSucessActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_success)

        val button = findViewById<AppCompatButton>(R.id.btnTrackMyOrder)
        button.setOnClickListener {
//            val intent = Intent(this, MainActivity::class.java)
//            intent.putExtra("FRAGMENT_TAG", "desired_fragment_tag");
//            startActivity(intent)
            finish()
        }
    }
}