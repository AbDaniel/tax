package com.pathasala.tax.model;

public class ImportedItem {

    private Item item;
    private double tax;

    public ImportedItem(Item item, double tax) {
        this.item = item;
        this.tax = tax;
    }

    public double afterTaxPrice() {
        return item.afterTaxPrice() + (item.afterTaxPrice() * tax / 100);
    }
}
