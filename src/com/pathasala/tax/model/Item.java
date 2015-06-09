package com.pathasala.tax.model;

public class Item {

    String name;
    double price;
    double tax;

    public Item(String name, double price, double tax) {
        this.name = name;
        this.price = price;
        this.tax = tax;
    }

    public double afterTaxPrice() {
        return price + (price * tax / 100);
    }

}
