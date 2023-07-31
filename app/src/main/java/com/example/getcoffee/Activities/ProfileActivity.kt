package com.example.getcoffee.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.getcoffee.Model.GlobalClass
import com.example.getcoffee.Model.ProfileItem
import com.example.getcoffee.R


class ProfileActivity : AppCompatActivity() {

    private var profiile: ProfileItem = GlobalClass.profileItem

    private var button1: ImageView? = null
    private var button2: ImageView? = null
    private var button3: ImageView? = null
    private var button4: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val name = findViewById<TextView>(R.id.txtFullName)
        name.text = profiile.name
        val phone = findViewById<TextView>(R.id.txtPhoneNumber)
        phone.text = profiile.phone
        val email = findViewById<TextView>(R.id.txtEmail)
        email.text = profiile.email
        val address = findViewById<TextView>(R.id.txtAddress)
        address.text = profiile.address


        val button = findViewById<ImageView>(R.id.toolbarEditButton)
        button.setOnClickListener {
            val intent = Intent(this, EditProfileActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()
        val name = findViewById<TextView>(R.id.txtFullName)
        name.text = profiile.name
        val phone = findViewById<TextView>(R.id.txtPhoneNumber)
        phone.text = profiile.phone
        val email = findViewById<TextView>(R.id.txtEmail)
        email.text = profiile.email
        val address = findViewById<TextView>(R.id.txtAddress)
        address.text = profiile.address

    }

    fun onBackButtonClicked(view: View) {
        finish()
    }

    fun onEditClicked(view: View) {
        finish()
        val intent = Intent(this, EditProfileActivity::class.java)
        startActivity(intent)
    }


}
