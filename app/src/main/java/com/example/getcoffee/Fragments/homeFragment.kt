package com.example.getcoffee.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.getcoffee.Adapters.featuredItemsAdapter
import com.example.getcoffee.Adapters.loyaltyPointsAdapter
import com.example.getcoffee.Model.CoffeeItem
import com.example.getcoffee.Model.LoyaltyCard
import com.example.getcoffee.Model.LoyaltyPoint
import com.example.getcoffee.Activities.MyCartActivity
import com.example.getcoffee.Activities.ProfileActivity
import com.example.getcoffee.Model.GlobalClass
import com.example.getcoffee.R

/**
 * A simple [Fragment] subclass.
 * Use the [homeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class homeFragment : Fragment() {

    private var profileButton: ImageView? = null
    private var cartButton: ImageView? = null


    private var loyaltyPoints: Int = 0
    private var loyaltyCard: LoyaltyCard = GlobalClass.loyaltyCard

    private var loyaltyPointsView: RecyclerView? = null
    private var featuredItemsView: RecyclerView? = null
    private var cupCounterView: TextView? = null


    private var coffeeList: MutableList<CoffeeItem>? = null
    private var LoyaltyPoints: MutableList<LoyaltyPoint>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val fragView = inflater.inflate(R.layout.fragment_home_page, container, false)


        // LoyaltyCard initialize recycler views
        loyaltyPointsView = fragView.findViewById(R.id.loyaltyPointsView)

        // LoyaltyCard stuffs initializing

        LoyaltyPoints = mutableListOf<LoyaltyPoint>()
        for (i in 1..loyaltyCard.maxPoint) {
            if (i <= loyaltyCard.curPoint) {
                LoyaltyPoints!!.add(LoyaltyPoint(R.drawable.img_light_coffee_cup))

            } else LoyaltyPoints!!.add(LoyaltyPoint(R.drawable.img_dark_coffee_cup))
        }

        setLoyaltyCardRecycler(LoyaltyPoints)


        // LoyaltyCard initialize cup counter
        cupCounterView = fragView.findViewById(R.id.cupCounterView)
        cupCounterView?.text =
            loyaltyCard!!.curPoint.toString() + " / " + "${loyaltyCard!!.maxPoint.toString()}"


        // FeaturedItems initialize recycler views
        featuredItemsView = fragView.findViewById(R.id.featuredItemsView)

        // Set up coffeeList
        coffeeList = mutableListOf<CoffeeItem>()
        coffeeList!!.add(CoffeeItem( "Americano", R.drawable.img_americano, 1, 3.00, 1, 3, 1, 2, 3,))
        coffeeList!!.add(CoffeeItem("Cappuccino", R.drawable.img_cappuccino, 1, 3.00, 1, 3, 1, 2, 3,))
        coffeeList!!.add(CoffeeItem("Mocha", R.drawable.img_mocha, 1, 3.00, 1, 3, 1, 2, 3,))
        coffeeList!!.add(CoffeeItem("Latte", R.drawable.img_latte, 1, 3.00, 1, 3, 1, 2, 3,))

        setFeaturedItemsRecycler(coffeeList)


        // Toolbar buttons and hooking up listeners
        profileButton = fragView.findViewById(R.id.profileButton)
        cartButton = fragView.findViewById(R.id.cartButton)

        profileButton?.setOnClickListener {
            val intent = Intent(activity, ProfileActivity::class.java)
            startActivity(intent)
        }
        cartButton?.setOnClickListener {
            val intent = Intent(activity, MyCartActivity::class.java)
            startActivity(intent)
        }


        // Inflate the layout for this fragment
        return fragView
    }

    override fun onResume() {
        super.onResume()
        // Refresh loyalty card cup counter
        cupCounterView?.text =
            loyaltyCard!!.curPoint.toString() + " / " + "${loyaltyCard!!.maxPoint.toString()}"
        LoyaltyPoints = mutableListOf()
        for (i in 1..loyaltyCard.maxPoint) {
            if (i <= loyaltyCard.curPoint) {
                LoyaltyPoints!!.add(LoyaltyPoint(R.drawable.img_light_coffee_cup))

            } else LoyaltyPoints!!.add(LoyaltyPoint(R.drawable.img_dark_coffee_cup))
        }
        setLoyaltyCardRecycler(LoyaltyPoints)
    }

    private fun setLoyaltyCardRecycler(LoyaltyPoints: MutableList<LoyaltyPoint>? = null) {
        val linearLayoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        val adapter = loyaltyPointsAdapter(LoyaltyPoints!!)
        loyaltyPointsView?.layoutManager = linearLayoutManager
        loyaltyPointsView?.adapter = adapter
    }

    private fun setFeaturedItemsRecycler(coffeeList: MutableList<CoffeeItem>? = null) {
        val gridLayoutManager = GridLayoutManager(activity, 2, GridLayoutManager.VERTICAL, false)
        val adapter = featuredItemsAdapter(coffeeList!!)
        featuredItemsView?.layoutManager = gridLayoutManager
        featuredItemsView?.adapter = adapter

    }

}