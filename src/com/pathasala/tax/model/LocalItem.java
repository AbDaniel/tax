package com.pathasala.tax.model;

public class LocalItem implements Item {

    private final String name;
    private double price;
    private double tax;

    public LocalItem(String name, double price, double tax) {
        this.name = name;
        this.price = price;
        this.tax = tax;
    }

    public LocalItem(String name) {
        this.name = name;
    }

    @Override
    public double afterTaxPrice() {
        return price + (price * tax / 100);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LocalItem localItem = (LocalItem) o;

        return !(name != null ? !name.equals(localItem.name) : localItem.name != null);

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return name + " at " + afterTaxPrice();
    }
}
