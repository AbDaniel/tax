package com.pathasala.tax.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImportedItemTest {

    ImportedItem importedItem;

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Object.class).usingGetClass();
    }

    @Before
    public void setUp() throws Exception {
        LocalItem localItem = new LocalItem("Gooli Soda", 100, 10);
        importedItem = new ImportedItem(localItem, 5);
    }

    @Test
    public void shouldComputeAfterTaxAmount() {
        double actualAmount = importedItem.afterTaxPrice();

        assertEquals(115.5, actualAmount, 0.005d);
    }
}