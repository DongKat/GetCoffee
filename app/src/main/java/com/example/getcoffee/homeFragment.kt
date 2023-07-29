package com.example.getcoffee

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
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

    private var loyaltyPointsView: RecyclerView? = null
    private var adapter1: loyaltyPointsAdapter? = null

    private var featuredItemsView: RecyclerView? = null
    private var adapter2: featuredItemsAdapter? = null


    private var coffeeList: ArrayList<CoffeeItem>? = null
    private var LoyaltyPoints: MutableList<LoyaltyPoint>? = null

    private var loyaltyCard: LoyaltyCard? = null

    private var cupCounterView: TextView? = null

    private fun setLoyaltyCardRecycler() {



    }

    private fun setFeaturedItemsRecycler() {


    }


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
        loyaltyCard = LoyaltyCard(2, 8)

        LoyaltyPoints = mutableListOf<LoyaltyPoint>()
        for (i in 1..loyaltyCard!!.maxPoint!!) {
            if (i <= loyaltyCard!!.curPoint!!) {
                LoyaltyPoints!!.add(LoyaltyPoint(R.drawable.img_light_coffee_cup))

            } else LoyaltyPoints!!.add(LoyaltyPoint(R.drawable.img_dark_coffee_cup))
        }

        val linearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        adapter1 = loyaltyPointsAdapter(LoyaltyPoints!!)

        loyaltyPointsView?.layoutManager = linearLayoutManager
        loyaltyPointsView?.adapter = adapter1

        // LoyaltyCard initialize cup counter
        cupCounterView = fragView.findViewById(R.id.cupCounterView)
        cupCounterView?.text =
            "${loyaltyCard!!.curPoint.toString()}" + " / " + "${loyaltyCard!!.maxPoint.toString()}"




//        // FeaturedItems initialize recycler views
//        featuredItemsView = fragView.findViewById(R.id.featuredItemsView)
//        featuredItemsView = view?.findViewById(R.id.featuredItemsView)
//        adapter2 = featuredItemsAdapter(coffeeList!!)


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
}

