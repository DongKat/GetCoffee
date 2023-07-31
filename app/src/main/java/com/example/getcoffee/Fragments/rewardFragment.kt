package com.example.getcoffee.Fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.getcoffee.Activities.RedeemRewardsActivity
import com.example.getcoffee.Adapters.historyAdapter
import com.example.getcoffee.Adapters.loyaltyPointsAdapter
import com.example.getcoffee.Model.GlobalClass
import com.example.getcoffee.Model.LoyaltyCard
import com.example.getcoffee.Model.LoyaltyPoint
import com.example.getcoffee.Model.RewardHistory
import com.example.getcoffee.R


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

    private var loyaltyCard: LoyaltyCard = GlobalClass.loyaltyCard
    private var loyaltyPoints: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragView = inflater.inflate(R.layout.fragment_rewards_page, container, false)


        loyaltyPointsView = fragView.findViewById(R.id.loyaltyPointsView)
        historyView = fragView.findViewById(R.id.rewardsHistory)

        redeemDrinksButton = fragView.findViewById(R.id.btnRedeemDrinks)


        // Set total points
        val totalPointsView = fragView.findViewById<TextView>(R.id.txtTotalPoints)
        totalPointsView.text = loyaltyCard.getTotalPoint().toString()


        // LoyaltyCard initialize cup counter
        cupCounterView = fragView.findViewById(R.id.cupCounterView)
        cupCounterView?.text =
            loyaltyCard!!.curPoint.toString() + " / " + "${loyaltyCard!!.maxPoint.toString()}"
        setLoyaltyCardRecycler()
        setHistoryRecycler()


        // Card view long click event
        loyaltyPointsView!!.setOnClickListener(View.OnClickListener {
            if (loyaltyCard.curPoint == loyaltyCard.maxPoint) {
                GlobalClass.loyaltyCard.resetPoint()
                loyaltyCard = GlobalClass.loyaltyCard
                cupCounterView?.text =
                    loyaltyCard!!.curPoint.toString() + " / " + "${loyaltyCard!!.maxPoint.toString()}"
                GlobalClass.rewardHistory.add(
                    RewardHistory(
                        "StickerBoom",
                        GlobalClass.currentDate,
                        100
                    )
                )
                setLoyaltyCardRecycler()
                setHistoryRecycler()
            }
        })

        redeemDrinksButton?.setOnClickListener {
            val intent = Intent(activity, RedeemRewardsActivity::class.java)
            startActivity(intent)
        }

        val cupsFrameView = fragView.findViewById<CardView>(R.id.frameloyaltycups)
        // Set touch listener for cardview
        cupsFrameView.setOnTouchListener(OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                if (loyaltyCard.curPoint == loyaltyCard.maxPoint) {
                    GlobalClass.loyaltyCard.resetPoint()
                    loyaltyCard = GlobalClass.loyaltyCard
                    cupCounterView?.text =
                        loyaltyCard!!.curPoint.toString() + " / " + "${loyaltyCard!!.maxPoint.toString()}"
                    GlobalClass.rewardHistory.add(
                        RewardHistory(
                            "StickerBoom",
                            GlobalClass.currentDate,
                            100
                        )
                    )
                    setLoyaltyCardRecycler()
                    setHistoryRecycler()
                }
            }
            false
        })




        return fragView
    }

    private fun setHistoryRecycler() {
        val historyRewards = GlobalClass.rewardHistory

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


}