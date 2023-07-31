package com.example.getcoffee.Fragments

import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.getcoffee.Adapters.orderAdapter
import com.example.getcoffee.Callbacks.SwipeToDeleteCallback
import com.example.getcoffee.Model.GlobalClass
import com.example.getcoffee.Model.OrderItem
import com.example.getcoffee.R

class orderFragment : Fragment() {
    private var orderList: ArrayList<OrderItem> = GlobalClass.onGoingOrder
    private var orderHistory: ArrayList<OrderItem> = GlobalClass.orderHistory
    private var fakebar: ImageView? = null

    private var FLAG = 0

    private var ongoingButton: TextView? = null
    private var historyButton: TextView? = null

    private var orderRecyclerView: RecyclerView? = null

    val swipeToDeleteCallback = object : SwipeToDeleteCallback() {
        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val position = viewHolder.adapterPosition
            val item = orderList[position]
            if (FLAG == 0) {
                orderList.removeAt(position)
                orderHistory.add(item)
            }
            orderRecyclerView?.adapter?.notifyItemRemoved(position)
        }
    }

    val itemTouchHelper = ItemTouchHelper(swipeToDeleteCallback)



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragView =
            inflater.inflate(R.layout.fragment_order_page, container, false)


        orderRecyclerView = fragView.findViewById(R.id.order_recycler_view)

        itemTouchHelper.attachToRecyclerView(orderRecyclerView)

        // swipe


        // Test data
//        orderList!!.add(OrderItem("Americano", 3.00, "12/12/2020", "3a Avenue Strt"))
//        orderList!!.add(OrderItem("Cappuccino", 3.00, "12/12/2020", "4a Mains Strt"))
//
//        orderHistory!!.add(OrderItem("Americano", 3.00, "12/12/2020", "8a Avenue Strt"))
//

        setOrderRecyclerView(orderList!!)
        fakebar = fragView.findViewById<ImageView>(R.id.fakeTabBar)

        ongoingButton = fragView.findViewById(R.id.txtOngoing)
        historyButton = fragView.findViewById(R.id.txtHistory)

        ongoingButton!!.setOnClickListener { view -> onOngoingClicked(view, orderList!!) }
        historyButton!!.setOnClickListener { view -> onHistoryClicked(view, orderHistory!!) }

        return fragView
    }

    fun onOngoingClicked(view: View, orderList: ArrayList<OrderItem>) {
        FLAG = 0
        // Refresh recyclerView
        setOrderRecyclerView(orderList)
        // change fakebar alignment to left of parent
        val params = fakebar?.layoutParams as RelativeLayout.LayoutParams
        params.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE)
        params.removeRule(RelativeLayout.ALIGN_PARENT_RIGHT)

    }

    fun onHistoryClicked(view: View, orderHistory: ArrayList<OrderItem>) {
        FLAG = 1
        // Refresh recyclerView
        setOrderRecyclerView(orderHistory)
        itemTouchHelper.attachToRecyclerView(null)
        // change fakebar alignment to right of parent
        val params = fakebar?.layoutParams as RelativeLayout.LayoutParams
        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE)
        params.removeRule(RelativeLayout.ALIGN_PARENT_LEFT)



    }

    private fun setOrderRecyclerView(orderlist: ArrayList<OrderItem>) {
        orderRecyclerView!!.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        orderRecyclerView!!.adapter = orderAdapter(orderlist)
    }

}