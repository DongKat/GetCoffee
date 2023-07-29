package com.example.getcoffee.Model

import java.util.Date


class CoffeeRewards {
    var name: String? = null
    var image: Int? = null
    var point: Int? = null
    var date: Date? = null
    var expiryDate: Date? = null

    // Redundant constructors
    constructor(name: String?, image: Int?, point: Int?, date: Date?, expiryDate: Date?) {
        this.name = name
        this.image = image
        this.point = point
        this.date = date
        this.expiryDate = expiryDate
    }

    // For history
    constructor(coffeeItem: CoffeeItem, purchaseDate: Date)
    {
        this.name = coffeeItem.name
        this.image = coffeeItem.image
        this.point = coffeeItem.point
        this.date = purchaseDate
    }

    // For rewards redeem
    constructor(name: String?, image: Int?, point: Int?, expiryDate: Date?) {
        this.name = name
        this.image = image
        this.point = point
        this.expiryDate = expiryDate
    }

}