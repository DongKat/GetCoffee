package com.example.getcoffee.Model

import android.media.Image
import java.util.Date

public class CoffeeItem()
{
    var name: String? = null
    var image: Int? = null
    var description: String? = null

    var quantity: Int? = null
    var price: Double? = null
    var point: Int? = null

    var size: Int? = null
    var coffeeShot: Int? = null
    var temperature: Int? = null
    var ice: Int? = null

    constructor(name: String?, image: Int?, quantity: Int?, price: Double?, point: Int?, size: Int?, coffeeShot: Int?, temperature: Int?, ice: Int?) : this() {
        this.name = name
        this.image = image
        this.description = description
        this.quantity = quantity
        this.price = price
        this.point = point
        this.size = size
        this.coffeeShot = coffeeShot
        this.temperature = temperature
        if (temperature == 1) {
            this.ice = 0
        } else {
            this.ice = ice
        }
    }

    constructor(reward: RedeemReward) : this() {
        this.name = reward.rewardName
        this.image = reward.rewardImage
        this.quantity = 0
        this.price = 0.00
        this.point = 12
        this.size = 1
        this.coffeeShot = 1
        this.temperature = 1
        this.ice = 0
    }

    constructor(name:String?, image:Int?) : this() {
        this.name = name
        this.image = image
    }

    constructor(name: String?, image:Int?, point: Int?) : this() {
        this.name = name
        this.image = image
        this.point = point
    }

    fun get_size(): String {
        if (size == 1) {
            return "Small"
        } else if (size == 2) {
            return "Medium"
        } else if (size == 3) {
            return "Large"
        } else {
            return "N/A"
        }
    }

    fun get_coffeeShot(): String {
        if (coffeeShot == 1) {
            return "Single"
        } else if (coffeeShot == 2) {
            return "Double"
        } else {
            return "N/A"
        }
    }

    fun get_temperature(): String {
        if (temperature == 1) {
            return "Hot"
        } else if (temperature == 2) {
            return "Cold"
        } else {
            return "N/A"
        }
    }

    fun get_ice(): String {
        if (temperature == 1)
            return "No ice"
        if (ice == 1) {
            return "Less Ice"
        } else if (ice == 2) {
            return "Half Ice"
        } else if (ice == 3) {
            return "Full ice"
        } else if (ice == 0) {
            return "No ice"
        } else {
            return "N/A"
        }
    }

    fun get_description(): String{
        return get_coffeeShot() + "|" + get_size() + "|" + get_temperature() + "|" + get_ice()
    }

    fun get_totalPrice(): Double {
        return price!! * quantity!!
    }

    fun get_totalPoint(): Int {
        return point!! * quantity!!
    }


}