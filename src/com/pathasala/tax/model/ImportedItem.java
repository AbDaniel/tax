package com.pathasala.tax.model;

public class ImportedItem implements Item {

    private final LocalItem localItem;
    private double tax;

    public ImportedItem(LocalItem localItem, double tax) {
        this.localItem = localItem;
        this.tax = tax;
    }

    @Override
    public double afterTaxPrice() {
        return localItem.afterTaxPrice() + (localItem.afterTaxPrice() * tax / 100);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImportedItem that = (ImportedItem) o;

        return !(localItem != null ? !localItem.equals(that.localItem) : that.localItem != null);

    }

    @Override
    public int hashCode() {
        return localItem != null ? localItem.hashCode() : 0;
    }
}
