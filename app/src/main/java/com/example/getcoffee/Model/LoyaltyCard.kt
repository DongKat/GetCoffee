package com.example.getcoffee.Model

import android.annotation.SuppressLint

class LoyaltyCard(cur: Int, max: Int, private var totalPoint: Int) {
    var curPoint:Int = cur
    var maxPoint:Int = max

    // A list to mark which cups to be faded
    var ListOfPoints:ArrayList<Int>? = null

    init {
        ListOfPoints = ArrayList<Int>()
        for (i in 1..maxPoint) {
            ListOfPoints?.add(0)
        }
    }

    fun increasePoint() {
        // Change list
        if (curPoint < maxPoint) {
            // Increase point
            curPoint = curPoint + 1
        }
        if (curPoint >= maxPoint) {
            curPoint = maxPoint
        }
        totalPoint = totalPoint + 1
        updateList()
    }

    fun updateList() {
        // Change list
        if (curPoint < maxPoint) {
            // Increase point
            for (i in 1..curPoint){
                ListOfPoints?.set(i-1, 1)
            }
        }
    }

    fun resetPoint() {
        // Change list
        for (i in 1..maxPoint){
            ListOfPoints?.set(i-1, 0)
        }
        curPoint = 0
    }

    fun getTotalPoint():Int {
        return totalPoint
    }

    fun setTotalPoint(i: Int) {
        totalPoint = i
    }


}