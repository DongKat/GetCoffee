package com.example.getcoffee

import android.annotation.SuppressLint
import android.content.Context
import  androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.getcoffee.Model.CoffeeItem
import com.example.getcoffee.Model.RedeemReward

class RedeemRewardsActivity : AppCompatActivity() {
    var rewardsList: MutableList<RedeemReward>? = null
    var rewardsView: RecyclerView? = null


    @SuppressLint("InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_redeem_rewards)



        // Recycler view
        // TODO: This somehow doesn't work
        rewardsView = findViewById<RecyclerView>(R.id.redeemRewardsView)
//
        setRewardsRecyclerView()

    }
    private fun setRewardsRecyclerView() {
        rewardsList = mutableListOf<RedeemReward>()
        rewardsList!!.add(RedeemReward("Americano", R.drawable.img_americano, 1340, "Valid until 31/12/2023"))
        rewardsList!!.add(RedeemReward("Cappuccino", R.drawable.img_cappuccino, 1340, "Valid until 31/12/2023"))
        rewardsList!!.add(RedeemReward("Mocha", R.drawable.img_mocha, 1340, "Valid until 31/12/2023"))
        rewardsList!!.add(RedeemReward("Latte", R.drawable.img_latte, 1340, "Valid until 31/12/2023"))

        val rewardsAdapter = RewardsAdapter(rewardsList!!, this)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rewardsView?.layoutManager = linearLayoutManager
        rewardsView?.adapter = rewardsAdapter
    }

    class RewardsAdapter(
        rewardsList: List<RedeemReward>,
        redeemRewardsActivity: RedeemRewardsActivity
    ) : RecyclerView.Adapter<RewardsAdapter.RewardsViewHolder>() {
        private var rewardsList: ArrayList<RedeemReward>? = rewardsList as ArrayList<RedeemReward>

        class RewardsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
               var rewardsName: TextView = itemView.findViewById(R.id.txtRedeemItemName)
            var rewardsImage: ImageView = itemView.findViewById(R.id.imgRedeemItem)
            var rewardsPoint: TextView = itemView.findViewById(R.id.btnRedeemItem)
            var validDate: TextView = itemView.findViewById(R.id.txtValidationDate)
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RewardsViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.card_coffee_redeem, parent, false)
            return RewardsViewHolder(view)
        }
        override fun onBindViewHolder(holder: RewardsViewHolder, position: Int) {
            holder.rewardsName.text = rewardsList!![position].rewardName
            holder.rewardsImage.setImageResource(rewardsList!![position].rewardImage!!)

            val tmpText = rewardsList!![position].rewardPoints.toString() + " pts"
            holder.rewardsPoint.text = tmpText
            holder.validDate.text = rewardsList!![position].validDate

        }
        override fun getItemCount(): Int {
            return rewardsList!!.size
        }

    }
    fun onBackButtonClicked(view: View) {
        finish()
    }


}