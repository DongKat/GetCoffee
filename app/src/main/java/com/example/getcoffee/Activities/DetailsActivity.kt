package com.example.getcoffee.Activities

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.getcoffee.Model.CoffeeItem
import com.example.getcoffee.Model.GlobalClass
import com.example.getcoffee.R

class DetailsActivity : AppCompatActivity() {

    var currentCoffeeItem: CoffeeItem = GlobalClass.tempCoffeeItem!!
    var quantity: Int = 1
    var temperature: Int = 2
    var size: Int = 3
    var coffeeShot: Int = 1
    var ice: Int = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val coffeeName = findViewById<TextView>(R.id.txtCoffeeName)
        coffeeName.text = currentCoffeeItem.name

        val coffeeImage = findViewById<ImageView>(R.id.imageCoffee)
        coffeeImage.setImageResource(currentCoffeeItem.image!!)

        val totalPriceView = findViewById<TextView>(R.id.txtPrice)
        totalPriceView.text = "$" + "%.2f".format(currentCoffeeItem.get_totalPrice())

        val cartButton = findViewById<ImageView>(R.id.imageCart)
        cartButton.setOnClickListener {
            val intent = Intent(this, MyCartActivity::class.java)
            startActivity(intent)
        }

        // Quantity buttons
        val quantityView = findViewById<TextView>(R.id.txtQuantity)
        val plusButton = findViewById<TextView>(R.id.btnPlus)
        val minusButton = findViewById<TextView>(R.id.btnMinus)
        plusButton.setOnClickListener {
            quantity++
            quantityView.text = quantity.toString()
            currentCoffeeItem.quantity = quantity
            totalPriceView.text = "$" + "%.2f".format(currentCoffeeItem.get_totalPrice())

        }
        minusButton.setOnClickListener {
            if (quantity > 0) {
                quantity--
                quantityView.text = quantity.toString()
                currentCoffeeItem.quantity = quantity
                totalPriceView.text = "$" + "%.2f".format(currentCoffeeItem.get_totalPrice())
            }
        }

        // Coffee shot buttons
        val singleShot = findViewById<TextView>(R.id.btnSingle)
        val doubleShot = findViewById<TextView>(R.id.btnDouble)
        val hotView = findViewById<ImageView>(R.id.imgHot)
        val coldView = findViewById<ImageView>(R.id.imgCold)
        val lessIceView = findViewById<ImageView>(R.id.imglessice)
        val halfIceView = findViewById<ImageView>(R.id.imghalfice)
        val fullIceView = findViewById<ImageView>(R.id.imgfullice)
        val smallView = findViewById<ImageView>(R.id.imgSmall)
        val mediumView = findViewById<ImageView>(R.id.imgMedium)
        val largeView = findViewById<ImageView>(R.id.imgLarge)
        singleShot.setOnClickListener {
            coffeeShot = 1
            singleShot.alpha = 1.0F
            doubleShot.alpha = 0.2F
        }
        doubleShot.setOnClickListener {
            coffeeShot = 2
            singleShot.alpha = 0.2F
            doubleShot.alpha = 1.0F
        }



        // Temperature buttons

        hotView.setOnClickListener {
            temperature = 1
            hotView.alpha = 1.0F
            coldView.alpha = 0.2F
            lessIceView.alpha = 0.2F
            halfIceView.alpha = 0.2F
            fullIceView.alpha = 0.2F
        }
        coldView.setOnClickListener {
            temperature = 2
            hotView.alpha = 0.2F
            coldView.alpha = 1.0F
            lessIceView.alpha = 0.2F
            halfIceView.alpha = 0.2F
            fullIceView.alpha = 1.0F
        }


        // Size buttons

        smallView.setOnClickListener {
            size = 1
            smallView.alpha = 1.0F
            mediumView.alpha = 0.2F
            largeView.alpha = 0.2F
        }
        mediumView.setOnClickListener {
            size = 2
            smallView.alpha = 0.2F
            mediumView.alpha = 1.0F
            largeView.alpha = 0.2F
        }
        largeView.setOnClickListener {
            size = 3
            smallView.alpha = 0.2F
            mediumView.alpha = 0.2F
            largeView.alpha = 1.0F
        }


        // Ice buttons
        lessIceView.setOnClickListener {
            if (temperature == 2) {
                ice = 1
                lessIceView.alpha = 1.0F
                halfIceView.alpha = 0.2F
                fullIceView.alpha = 0.2F
            }
        }
        halfIceView.setOnClickListener {
            if (temperature == 2) {
                ice = 2
                lessIceView.alpha = 0.2F
                halfIceView.alpha = 1.0F
                fullIceView.alpha = 0.2F
            }
        }
        fullIceView.setOnClickListener {
            if (temperature == 2) {
                ice = 3
                lessIceView.alpha = 0.2F
                halfIceView.alpha = 0.2F
                fullIceView.alpha = 1.0F
            }
        }


        val checkOutbutton = findViewById<TextView>(R.id.btnAddToCart)
        checkOutbutton.setOnClickListener {
            currentCoffeeItem.coffeeShot = coffeeShot
            currentCoffeeItem.temperature = temperature
            currentCoffeeItem.size = size
            currentCoffeeItem.ice = ice
            GlobalClass.addCoffeeItemToCart(currentCoffeeItem)
            val intent = Intent(this, MyCartActivity::class.java)
            startActivity(intent)
            finish()
        }

        val backButton = findViewById<ImageView>(R.id.imageBack)
        backButton.setOnClickListener {
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
    }


}