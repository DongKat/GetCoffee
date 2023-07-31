package com.example.getcoffee.Adapters

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.getcoffee.Model.RewardHistory
import com.example.getcoffee.R

class historyAdapter(history: List<RewardHistory>) : RecyclerView.Adapter<historyAdapter.historyViewHolder>() {
    var historyList: ArrayList<RewardHistory> = history as ArrayList<RewardHistory>

    private val VIEW_TYPE_EMPTY = 0

    class historyViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        var coffeeName: TextView =  itemview.findViewById(R.id.txtCoffeeName)
        var rewardDate: TextView = itemview.findViewById(R.id.txtRewardDate)
        var rewardPoints: TextView = itemview.findViewById(R.id.txtRewardPoints)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): historyViewHolder {
        if (historyList.isEmpty()) {
            val emptyView = LayoutInflater.from(parent.context).inflate(R.layout.card_empty_item, parent, false)
            return historyViewHolder(emptyView)
        }
        else
        {
            val v = LayoutInflater.from(parent.context).inflate(R.layout.card_reward_history, parent, false)
            return historyViewHolder(v)
        }
    }

    override fun getItemCount(): Int {
        return historyList.size
    }

    override fun onBindViewHolder(holder: historyViewHolder, position: Int) {
        holder.coffeeName.text = historyList[position].coffeeName
        holder.rewardDate.text = historyList[position].rewardDate
        holder.rewardPoints.text = "+ " + historyList[position].rewardPoints.toString() + "pts"
    }

}
