package com.pathasala.tax.factory;

import com.pathasala.tax.model.Item;
import com.pathasala.tax.model.LocalItem;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemFactoryTest {

    ItemFactory itemFactory;

    @Mock
    List<Item> itemList;

    @Mock
    Map<String, List<Item>> taxExemptMap;

    @Test
    public void shouldVerifyEqualsContract() {
        EqualsVerifier.forClass(Object.class).usingGetClass();
    }

    private void setUpWithData() {
        taxExemptMap = new HashMap<>();
        Item item = new LocalItem("Gooli Soda");
        itemList = new ArrayList<>();
        itemList.add(item);
        taxExemptMap.put("food", itemList);
        itemFactory = new ItemFactory(taxExemptMap);
    }

    @Before
    public void setUp() throws Exception {
        itemFactory = new ItemFactory(taxExemptMap);
    }

    @Test
    public void shouldAddItemToTaxExemption() {
        String type = "food";
        when(taxExemptMap.get("food")).thenReturn(itemList);
        Item item = new LocalItem("Gooli Soda");

        itemFactory.addItemToTaxExemption(type, item);

        verify(itemList).add(item);
    }

    @Test
    public void shouldMakeItemWhichIsNotTaxExempt() {
        setUpWithData();
        Item item = itemFactory.makeLocalItem("Not Gooli Soda", 100);

        double actualPrice = item.afterTaxPrice();

        assertEquals(110, actualPrice, 0.005d);
    }

    @Test
    public void shouldMakeItemWhichIsTaxExempt() {
        setUpWithData();
        Item item = itemFactory.makeLocalItem("Gooli Soda", 100);

        double actualPrice = item.afterTaxPrice();

        assertEquals(100, actualPrice, 0.005d);
    }

}