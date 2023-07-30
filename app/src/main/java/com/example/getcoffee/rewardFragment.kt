package com.example.getcoffee

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.getcoffee.Adapters.historyAdapter
import com.example.getcoffee.Adapters.loyaltyPointsAdapter
import com.example.getcoffee.Model.LoyaltyCard
import com.example.getcoffee.Model.LoyaltyPoint
import com.example.getcoffee.Model.RewardHistory

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [homeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class rewardFragment : Fragment() {

    private var redeemDrinksButton: FrameLayout? = null

    private var loyaltyPointsView: RecyclerView? = null
    private var historyView: RecyclerView? = null
    private var cupCounterView: TextView? = null

    private var loyaltyCard: LoyaltyCard? = null
    private var loyaltyPoints: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragView = inflater.inflate(R.layout.fragment_rewards_page, container, false)


        loyaltyPointsView = fragView.findViewById(R.id.loyaltyCupsView)
        historyView = fragView.findViewById(R.id.rewardsHistory)

        redeemDrinksButton = fragView.findViewById(R.id.btnRedeemDrinks)


        // LoyaltyCard stuffs initializing
        loyaltyCard = LoyaltyCard(0, 8, 2)

        // LoyaltyCard initialize cup counter
        cupCounterView = fragView.findViewById(R.id.cupCounter)
        cupCounterView?.text =
            loyaltyCard!!.curPoint.toString() + " / " + "${loyaltyCard!!.maxPoint.toString()}"



        setLoyaltyCardRecycler()
        setHistoryRecycler()

        redeemDrinksButton?.setOnClickListener {
            val intent = Intent(activity, RedeemRewardsActivity::class.java)
            startActivity(intent)
        }



        return fragView
    }

    private fun setHistoryRecycler() {
        val historyRewards = mutableListOf<RewardHistory>()

        val linearLayoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        val adapter = historyAdapter(historyRewards)
        historyView?.layoutManager = linearLayoutManager
        historyView?.adapter = adapter
    }

    private fun setLoyaltyCardRecycler() {

        val LoyaltyPoints = mutableListOf<LoyaltyPoint>()
        for (i in 1..loyaltyCard!!.maxPoint!!) {
            if (i <= loyaltyCard!!.curPoint!!) {
                LoyaltyPoints.add(LoyaltyPoint(R.drawable.img_light_coffee_cup))

            } else LoyaltyPoints.add(LoyaltyPoint(R.drawable.img_dark_coffee_cup))
        }
        val linearLayoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        val adapter = loyaltyPointsAdapter(LoyaltyPoints)
        loyaltyPointsView?.layoutManager = linearLayoutManager
        loyaltyPointsView?.adapter = adapter
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
        fun newInstance(param1: String, param2: String) =
            homeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}