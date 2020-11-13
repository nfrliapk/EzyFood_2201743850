package com.example.ezyfood;

import java.util.ArrayList;

public class DatabaseSample {
    public static ArrayList<Mycart> cartItems;

    public static void addItem(Mycart cart){
        if(cartItems == null)
            cartItems = new ArrayList<>();
        cartItems.add(cart);
    }

    public static Long getPrice(){
        Long totalPrice = 0L;

        if(cartItems == null)
            cartItems = new ArrayList<>();

        for(Mycart item: cartItems)
            totalPrice += Integer.valueOf(item.getHargaProduk()) * Integer.valueOf(item.getQty());

        return totalPrice;
    }
}
