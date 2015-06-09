package com.pathasala.tax.model;

public class Item {

    String name;
    double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double afterTaxPrice(Tax tax) {
        return price + tax.computeTax(price);
    }

}
