package com.example.getcoffee.Adapters

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.getcoffee.Model.OrderItem
import com.example.getcoffee.R

class orderAdapter(orders: List<OrderItem>): RecyclerView.Adapter<orderAdapter.orderViewHolder>() {
    class orderViewHolder(view:View): RecyclerView.ViewHolder(view) {
        val coffeeName: TextView = itemView.findViewById(R.id.txtOrderName)
        val address: TextView = itemView.findViewById(R.id.txtOrderAddress)
        val date: TextView = itemView.findViewById(R.id.txtOrderDate)
        val price: TextView = itemView.findViewById(R.id.txtOrderPrice)


    }

    val orderList: ArrayList<OrderItem> = orders as ArrayList<OrderItem>

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): orderAdapter.orderViewHolder {
        // Check if list empty
        if (orderList.isEmpty()) {
            val v = View.inflate(parent.context, R.layout.card_empty_item, null)
            return orderViewHolder(v)
        }
        else    {
            val v = View.inflate(parent.context, R.layout.card_order_item, null)
            return orderViewHolder(v)
        }

    }

    override fun onBindViewHolder(holder: orderAdapter.orderViewHolder, position: Int) {
        holder.coffeeName.text = orderList[position].coffeName
        holder.address.text = orderList[position].address
        holder.date.text = orderList[position].date
        holder.price.text = orderList[position].get_price()
    }

    override fun getItemCount(): Int {
        return orderList.size
    }
}