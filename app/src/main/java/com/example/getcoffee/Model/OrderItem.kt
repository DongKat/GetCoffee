package com.example.getcoffee.Model

class OrderItem(
    var coffeName: String,
    var price: Double,
    var date: String,
    var address: String

) {

    constructor(item: CoffeeItem) : this("", 0.0, "", "") {
        this.coffeName = item.name!!
        this.price = item.get_totalPrice()
        this.date = GlobalClass.currentDate
        this.address = GlobalClass.profileItem.address.toString()
    }


    fun get_price(): String {
        val tmptxt = "$" + "%.2f".format(price)
        return tmptxt
    }


}