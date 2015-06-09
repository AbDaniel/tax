package com.pathasala.tax.factory;

import com.pathasala.tax.model.Item;
import com.pathasala.tax.model.LocalItem;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

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
    public void equalsContract() {
        EqualsVerifier.forClass(Object.class).usingGetClass();
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
}