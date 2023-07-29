package com.example.getcoffee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView


class ProfileActivity : AppCompatActivity() {

    private var button1: ImageView? = null
    private var button2: ImageView? = null
    private var button3: ImageView? = null
    private var button4: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        button1 = findViewById(R.id.btnEditName)
        button1?.setOnClickListener {
            editName()
        }
        button2 = findViewById(R.id.btnEditPhone)
        button2?.setOnClickListener {
            editPhone()
        }
        button3 = findViewById(R.id.btnEditEmail)
        button3?.setOnClickListener {
            editEmail()
        }
        button4 = findViewById(R.id.btnEditAddress)
        button4?.setOnClickListener {
            editAddress()
        }

    }

    fun onBackButtonClicked(view: View) {
        finish()
    }

    private fun editName() {
        // Hide the text view and show the edit text
        val tvName = findViewById<TextView>(R.id.txtFullName)
        val etName = findViewById<EditText>(R.id.edtFullName)
        tvName.visibility = View.GONE
        etName.visibility = View.VISIBLE
        // Get the text from the text view
        val name = tvName.text.toString()
        // Set the text to the edit text
        etName.setText(name)

        // Hide the edit text and show the text view
        etName.visibility = View.GONE
        tvName.visibility = View.VISIBLE
        // Get the text from the edit text
        val newName = etName.text.toString()
        // Set the text to the text view
        tvName.setText(newName)


    }
    private fun editPhone() {
        val tvName = findViewById<TextView>(R.id.txtPhoneNumber)
        val etName = findViewById<EditText>(R.id.edtPhoneNumber)
        tvName.visibility = View.GONE
        etName.visibility = View.VISIBLE
        // Get the text from the text view
        val name = tvName.text.toString()
        // Set the text to the edit text
        etName.setText(name)

        // Hide the edit text and show the text view
        etName.visibility = View.GONE
        tvName.visibility = View.VISIBLE
        // Get the text from the edit text
        val newName = etName.text.toString()
        // Set the text to the text view
        tvName.setText(newName)

    }
    private fun editEmail() {
        val tvName = findViewById<TextView>(R.id.txtEmail)
        val etName = findViewById<EditText>(R.id.edtEmail)
        tvName.visibility = View.GONE
        etName.visibility = View.VISIBLE
        // Get the text from the text view
        val name = tvName.text.toString()
        // Set the text to the edit text
        etName.setText(name)

        // Hide the edit text and show the text view
        etName.visibility = View.GONE
        tvName.visibility = View.VISIBLE
        // Get the text from the edit text
        val newName = etName.text.toString()
        // Set the text to the text view
        tvName.setText(newName)
    }
    private fun editAddress() {
        val tvName = findViewById<TextView>(R.id.txtAddress)
        val etName = findViewById<EditText>(R.id.edtAddress)
        tvName.visibility = View.GONE
        etName.visibility = View.VISIBLE
        // Get the text from the text view
        val name = tvName.text.toString()
        // Set the text to the edit text
        etName.setText(name)

        // Hide the edit text and show the text view
        etName.visibility = View.GONE
        tvName.visibility = View.VISIBLE
        // Get the text from the edit text
        val newName = etName.text.toString()
        // Set the text to the text view
        tvName.setText(newName)
    }







}
