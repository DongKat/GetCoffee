package com.example.getcoffee.Model

import android.media.Image

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

    constructor(name: String?, image: Int?, description: String?, quantity: Int?, price: Double?, point: Int?, size: Int?, coffeeShot: Int?, temperature: Int?, ice: Int?) : this() {
        this.name = name
        this.image = image
        this.description = description
        this.quantity = quantity
        this.price = price
        this.point = point
        this.size = size
        this.coffeeShot = coffeeShot
        this.temperature = temperature
        this.ice = ice
    }

    constructor(name:String, image:Int) : this() {
        this.name = name
        this.image = image
    }

    constructor(name: String?, point: Int?) : this() {
        this.name = name
        this.point = point
    }
}