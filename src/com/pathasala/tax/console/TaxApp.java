package com.pathasala.tax.console;

import com.pathasala.tax.factory.ItemFactory;
import com.pathasala.tax.model.Item;
import com.pathasala.tax.model.LocalItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaxApp {

    ItemFactory itemFactory;

    public static void main(String[] args) {
        List<Item> foodItems = new ArrayList<>();
        foodItems.add(new LocalItem("chocolate bar"));
        foodItems.add(new LocalItem("chocolates"));
        List<Item> medicines = new ArrayList<>();
        medicines.add(new LocalItem("headache pills"));
        List<Item> books = new ArrayList<>();
        books.add(new LocalItem("book"));

        Map<String, List<Item>> taxExempt = new HashMap<>();
        taxExempt.put("food", foodItems);
        taxExempt.put("medicine", medicines);
        taxExempt.put("book", books);
    }

}
