package com.pathasala.tax.model;

public class ImportedItem implements Item {

    private final Item item;
    private double tax;

    public ImportedItem(Item item, double tax) {
        this.item = item;
        this.tax = tax;
    }

    @Override
    public double afterTaxPrice() {
        return item.afterTaxPrice() + (item.afterTaxPrice() * tax / 100);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImportedItem that = (ImportedItem) o;

        return !(item != null ? !item.equals(that.item) : that.item != null);

    }

    @Override
    public int hashCode() {
        return item != null ? item.hashCode() : 0;
    }
}
