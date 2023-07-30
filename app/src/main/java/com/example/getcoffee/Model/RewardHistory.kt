package com.example.getcoffee.Model

import java.util.Date

class RewardHistory(var coffeeName: String?, var rewardDate: Date?, var rewardPoints: Int?) {
    fun get_rewardDate(): String? {
        var tmp_string: String? = ""
        tmp_string += rewardDate?.date.toString() + "-"
        tmp_string += rewardDate?.month.toString() + "-"
        tmp_string += rewardDate?.year.toString()
        return tmp_string
    }
}