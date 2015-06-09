package com.pathasala.tax.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LocalItemTest {

    LocalItem localItem;

    @Before
    public void setUp() {
        localItem = new LocalItem("Gooli Soda", 100, 10);
    }

    @Test
    public void shouldVerifyEqualsContract() {
        EqualsVerifier.forClass(LocalItem.class).usingGetClass();
    }

    @Test
    public void shouldComputeAfterTaxAmount() {
        double actualAmount = localItem.afterTaxPrice();

        assertEquals(110, actualAmount, 0.005d);
    }

}