package com.pathasala.tax.model;


import com.pathasala.tax.strategy.Tax;

public class Item {

    double price;
    Tax tax;

    public Item(double price) {
        this.price = price;
    }

}
