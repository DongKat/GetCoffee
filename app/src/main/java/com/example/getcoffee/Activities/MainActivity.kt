package com.example.getcoffee.Activities

import android.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.getcoffee.Fragments.orderFragment
import com.example.getcoffee.Model.GlobalClass
import com.example.getcoffee.Model.LoyaltyCard
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    public var loyaltyCard: LoyaltyCard = GlobalClass.loyaltyCard
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.getcoffee.R.layout.activity_main)

        if (intent.extras != null) {
            val fragmentTag = intent.getStringExtra("FRAGMENT_TAG")
            if (fragmentTag != null) {
                // Use a FragmentManager to navigate to the desired fragment
                val fragmentManager: FragmentManager = supportFragmentManager
                val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
                if (fragmentTag == "desired_fragment_tag") {
                    val fragment = orderFragment()
                    fragmentTransaction.replace(
                        com.example.getcoffee.R.id.nav_host_fragment,
                        fragment,
                        "desired_fragment_tag"
                    )
                    // Add the fragment to the back stack if necessary
                    fragmentTransaction.addToBackStack(null)
                }
                fragmentTransaction.commit()
            }
        }


        val bottomNavigationView = findViewById<BottomNavigationView>(com.example.getcoffee.R.id.bottomNavigationView)
        val navHostFragment = supportFragmentManager.findFragmentById(com.example.getcoffee.R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        bottomNavigationView.setupWithNavController(navController)
    }
}
