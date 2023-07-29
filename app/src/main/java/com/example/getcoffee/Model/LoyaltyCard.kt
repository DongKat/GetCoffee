package com.example.getcoffee.Model

import android.annotation.SuppressLint

class LoyaltyCard(cur: Int,  max: Int) {
    var curPoint:Int = cur
    var maxPoint:Int = max

    // A list to mark which cups to be faded
    var ListOfPoints:ArrayList<Int>? = null

    init {
        ListOfPoints = ArrayList<Int>()
        for (i in 0..maxPoint!!) {
            ListOfPoints?.add(0)
        }
    }

    fun increasePoint() {
        // Change list
        ListOfPoints?.set(curPoint!!, 1)
        if (curPoint!! < maxPoint!!) {
            // Increase point
            curPoint = curPoint!! + 1
        }
    }

    fun isMax():Boolean {
        return curPoint == maxPoint
    }

    fun resetPoint() {
        // Change list
        for (i in 0..maxPoint!!) {
            ListOfPoints?.set(i, 0)
        }
        curPoint = 0
    }


}