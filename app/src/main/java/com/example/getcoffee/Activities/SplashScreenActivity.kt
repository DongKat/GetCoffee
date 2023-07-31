package com.example.getcoffee.Activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.getcoffee.R

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {

    private val SPLASH_DISPLAY_LENGTH = 1000 // Duration of splash screen in milliseconds (2 seconds)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        Handler().postDelayed({
            // Start the main activity after the splash screen duration
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // This prevents the user from navigating back to the splash screen using the back button
        }, SPLASH_DISPLAY_LENGTH.toLong())
    }
}