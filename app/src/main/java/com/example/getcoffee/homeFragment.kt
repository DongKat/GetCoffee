package com.example.getcoffee

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


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [homeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class homeFragment : Fragment() {

    private var profileButton: ImageView? = null
    private var cartButton: ImageView? = null


    private var loyaltyPoints: Int = 0
    private var loyaltyCard: LoyaltyCard? = null

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
        loyaltyCard = LoyaltyCard(0, 8, 0)

        LoyaltyPoints = mutableListOf<LoyaltyPoint>()
        for (i in 1..loyaltyCard!!.maxPoint) {
            if (i <= loyaltyCard!!.curPoint) {
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
        coffeeList!!.add(CoffeeItem("Americano", R.drawable.img_americano))
        coffeeList!!.add(CoffeeItem("Cappuccino", R.drawable.img_cappuccino))
        coffeeList!!.add(CoffeeItem("Mocha", R.drawable.img_mocha))
        coffeeList!!.add(CoffeeItem("Latte", R.drawable.img_latte))

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

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment homeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) = homeFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_PARAM1, param1)
                putString(ARG_PARAM2, param2)
            }
        }
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

