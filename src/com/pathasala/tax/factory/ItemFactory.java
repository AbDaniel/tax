package com.pathasala.tax.factory;

import com.pathasala.tax.model.Item;
import com.pathasala.tax.model.LocalItem;

import java.util.List;
import java.util.Map;

public class ItemFactory {

    public static final int TAX_EXEMPTED_PERCENTAGE = 0;
    public static final int SALES_TAX_PERCENTAGE = 10;

    private Map<String, List<Item>> taxExemptMap;

    public ItemFactory(Map<String, List<Item>> taxExemptMap) {
        this.taxExemptMap = taxExemptMap;
    }

    public Item makeLocalItem(String name, double price) {
        Item item = new LocalItem(name);
        for (Map.Entry<String, List<Item>> entry : taxExemptMap.entrySet()) {
            if (entry.getValue().contains(item))
                return new LocalItem(name, price, TAX_EXEMPTED_PERCENTAGE);
        }
        return new LocalItem(name, price, SALES_TAX_PERCENTAGE);
    }

    public void addItemToTaxExemption(String type, Item item) {
        List<Item> typeItemMap = taxExemptMap.get(type);
        typeItemMap.add(item);
    }

}
