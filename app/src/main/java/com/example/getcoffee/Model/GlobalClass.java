package com.example.getcoffee.Model;

import android.app.Application;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class GlobalClass extends Application {

    static Date c = Calendar.getInstance().getTime();
    // Take the day, month, year, hour, minute from date
    public static String currentDate = c.getDay() + "/" + c.getMonth() + "/" + c.getYear() + " | " + c.getHours() + ":" + c.getMinutes();

    public static LoyaltyCard loyaltyCard = new LoyaltyCard(0, 8, 4000);
    public static ProfileItem profileItem = new ProfileItem("Anderson", "anderson@email.com", "1234567890", "123 Main St Apt 1 New York NY");
    public static ArrayList<OrderItem> onGoingOrder = new ArrayList<>();
    public static ArrayList<OrderItem> orderHistory = new ArrayList<>();
    public static ArrayList<CoffeeItem> cart = new ArrayList<>();
    public static ArrayList<RewardHistory> rewardHistory = new ArrayList<>();

    public static CoffeeItem tempCoffeeItem = null;

    public static void addCoffeeItemToCart(CoffeeItem coffeeItem) {
        cart.add(coffeeItem);
    }

    public static void removeCoffeeItemFromCart(CoffeeItem coffeeItem) {
        cart.remove(coffeeItem);
    }

    public static void clearCart() {
        cart.clear();
    }

    public static void addOrderToHistory(OrderItem orderItem) {
        orderHistory.add(orderItem);
    }

    public static void addOrderToOnGoing(OrderItem orderItem) {
        onGoingOrder.add(orderItem);
    }

    public static void removeOrderFromOnGoing(OrderItem orderItem) {
        onGoingOrder.remove(orderItem);
    }

    public static void addRewardToHistory(RewardHistory reward) {
        rewardHistory.add(reward);
    }

    public static void removeRewardFromHistory(RewardHistory reward) {
        rewardHistory.remove(reward);
    }

    public static void clearRewardHistory() {
        rewardHistory.clear();
    }

    public static void clearOrderHistory() {
        orderHistory.clear();
    }

    public static void clearOnGoingOrder() {
        onGoingOrder.clear();
    }

    public static void clearLoyaltyCard() {
        loyaltyCard = new LoyaltyCard(0, 0, 0);
    }

    public static void clearProfileItem() {
        profileItem = new ProfileItem("", "", "", "");
    }

    public static void clearTempCoffeeItem() {
        tempCoffeeItem = null;
    }

    public static void clearAll() {
        clearCart();
        clearLoyaltyCard();
        clearOnGoingOrder();
        clearOrderHistory();
        clearProfileItem();
        clearRewardHistory();
        clearTempCoffeeItem();
    }

    public static void addPointToLoyaltyCard() {
        for (CoffeeItem coffeeItem : cart) {
            for (int i = 0; i < coffeeItem.getQuantity(); i++) {
                loyaltyCard.increasePoint();
            }
        }
    }


    public static void addRewardHistory(@NotNull RewardHistory history) {
        rewardHistory.add(history);
    }
}
