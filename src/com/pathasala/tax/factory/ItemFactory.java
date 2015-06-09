package com.pathasala.tax.factory;

import com.pathasala.tax.model.Item;

import java.util.List;
import java.util.Map;

public class ItemFactory {

    private Map<String, List<Item>> taxExemptList;

    public ItemFactory(Map<String, List<Item>> taxExemptList) {
        this.taxExemptList = taxExemptList;
    }

    public void addItemToTaxExemption(String type, Item item) {
        List<Item> typeItemMap = taxExemptList.get(type);
        typeItemMap.add(item);
    }

}
