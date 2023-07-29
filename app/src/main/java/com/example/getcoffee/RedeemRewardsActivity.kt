package com.example.getcoffee

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

class RedeemRewardsActivity : AppCompatActivity() {
    var rewardsList: ArrayList<CoffeeItem>? = null
    var rewardsView: RecyclerView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = layoutInflater.inflate(R.layout.activity_redeem_rewards, null)
        setContentView(view)

        // Recycler view
        rewardsView = view.findViewById(R.id.redeemRewardsView)

        rewardsList = ArrayList<CoffeeItem>()
        rewardsList!!.add(CoffeeItem("Americano", R.drawable.img_americano, 1340))
        rewardsList!!.add(CoffeeItem("Cappuccino", R.drawable.img_americano, 1340))
        rewardsList!!.add(CoffeeItem("Mocha", R.drawable.img_latte, 1340))
        rewardsList!!.add(CoffeeItem("Latte", R.drawable.img_latte, 1340))

        setRewardsRecyclerView()


    }
    private fun setRewardsRecyclerView() {
        val rewardsAdapter = RewardsAdapter(rewardsList!!, this)
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rewardsView?.layoutManager = linearLayoutManager
        rewardsView?.adapter = rewardsAdapter
    }

    class RewardsAdapter(
        rewardsList: ArrayList<CoffeeItem>,
        redeemRewardsActivity: RedeemRewardsActivity
    ) : RecyclerView.Adapter<RewardsAdapter.RewardsViewHolder>() {
        private var rewardsList: ArrayList<CoffeeItem>? = rewardsList

        class RewardsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var rewardsName: TextView = itemView.findViewById(R.id.txtRedeemItemName)
            var rewardsImage: ImageView = itemView.findViewById(R.id.imgRedeemItem)
            var rewardsPoint: TextView = itemView.findViewById(R.id.btnRedeemItem)
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RewardsViewHolder {
            return RewardsViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.card_coffee_redeem, parent, false)
            )
        }
        override fun onBindViewHolder(holder: RewardsViewHolder, position: Int) {
            holder.rewardsName.text = rewardsList!![position].name
            holder.rewardsImage.setImageResource(rewardsList!![position].image!!)

            val tmpText = rewardsList!![position].point.toString() + " pts"
            holder.rewardsPoint.text = tmpText

        }
        override fun getItemCount(): Int {
            return rewardsList!!.size
        }

    }
    fun onBackButtonClicked(view: View) {
        finish()
    }


}