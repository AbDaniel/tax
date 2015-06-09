package com.pathasala.tax.model;

import com.pathasala.tax.strategy.Tax;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ItemTest {

    Item item;

    @Before
    public void setUp() {
        item = new Item("Gooli Soda", 100);
    }

    @Test
    public void shouldVerifyEqualsContract() {
        EqualsVerifier.forClass(Object.class).usingGetClass();
    }

    @Test
    public void shouldComputeAfterTaxAmount() {
        Tax tax = new Tax(10);

        double actualAmount = item.afterTaxPrice(tax);

        assertEquals(110, actualAmount, 0.005d);
    }

}