package com.example.getcoffee.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.getcoffee.Model.LoyaltyCard
import com.example.getcoffee.Model.LoyaltyPoint
import com.example.getcoffee.R

class loyaltyPointsAdapter(list: List<LoyaltyPoint>) : RecyclerView.Adapter<loyaltyPointsAdapter.loyaltyPointsViewHolder>() {
    var cupList: ArrayList<LoyaltyPoint> = list as ArrayList<LoyaltyPoint>

    class loyaltyPointsViewHolder (view: View): RecyclerView.ViewHolder(view) {
        var loyaltyCupView: ImageView = view.findViewById(R.id.loyaltyCupView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): loyaltyPointsViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(com.example.getcoffee.R.layout.card_loyalty_coffee_cup, parent, false)
        return loyaltyPointsViewHolder(v)
    }

    override fun getItemCount(): Int {
        return cupList.size

    }

    override fun onBindViewHolder(holder: loyaltyPointsViewHolder, position: Int) {
        holder.loyaltyCupView?.setImageResource(cupList[position].cupImage!!)
    }

}

