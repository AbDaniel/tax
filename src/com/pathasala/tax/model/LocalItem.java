package com.pathasala.tax.model;

public class LocalItem implements Item {

    String name;
    double price;
    double tax;

    public LocalItem(String name, double price, double tax) {
        this.name = name;
        this.price = price;
        this.tax = tax;
    }

    @Override
    public double afterTaxPrice() {
        return price + (price * tax / 100);
    }

}
