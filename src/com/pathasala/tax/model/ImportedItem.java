package com.pathasala.tax.model;

public class ImportedItem implements Item {

    private LocalItem localItem;
    private double tax;

    public ImportedItem(LocalItem localItem, double tax) {
        this.localItem = localItem;
        this.tax = tax;
    }

    @Override
    public double afterTaxPrice() {
        return localItem.afterTaxPrice() + (localItem.afterTaxPrice() * tax / 100);
    }
}
