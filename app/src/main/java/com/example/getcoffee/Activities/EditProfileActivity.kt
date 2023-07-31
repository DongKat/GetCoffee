package com.example.getcoffee.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import com.example.getcoffee.Model.GlobalClass
import com.example.getcoffee.Model.ProfileItem
import com.example.getcoffee.R

class EditProfileActivity : AppCompatActivity() {

    val profile : ProfileItem = GlobalClass.profileItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        val hintName = findViewById<EditText>(R.id.edtFullName)
        hintName.hint = profile.name
        val hintPhone = findViewById<EditText>(R.id.edtPhoneNumber)
        hintPhone.hint = profile.phone
        val hintEmail = findViewById<EditText>(R.id.edtEmail)
        hintEmail.hint = profile.email
        val hintAddress = findViewById<EditText>(R.id.edtAddress)
        hintAddress.hint = profile.address

        val backButton = findViewById<ImageView>(R.id.imageBack)
        backButton.setOnClickListener {
            finish()
        }

    }

    fun onCompleteClicked(view: View) {
        // Get edited text
        val newName = findViewById<EditText>(R.id.edtFullName)
        val newPhone = findViewById<EditText>(R.id.edtPhoneNumber)
        val newEmail = findViewById<EditText>(R.id.edtEmail)
        val newAddress = findViewById<EditText>(R.id.edtAddress)
        // Update profile
        if (newName.text.toString() != "") {
            profile.name = newName.text.toString()
        }
        if (newPhone.text.toString() != "") {
            profile.phone = newPhone.text.toString()
        }
        if (newEmail.text.toString() != "") {
            profile.email = newEmail.text.toString()
        }
        if (newAddress.text.toString() != "") {
            profile.address = newAddress.text.toString()
        }
        // Go back to profile
        finish()
    }
    fun onBackButtonClicked(view: View) {
        // Go back to profile without saving changes
        finish()
    }
}