package com.pathasala.tax.strategy;

import com.pathasala.tax.model.Tax;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TaxTest {

    Tax tax;

    @Before
    public void setUp() {
        tax = new Tax(10);
    }

    @Test
    public void shouldComputeTaxOnGivenAmount() {
        double amount = 100;

        double actualTax = tax.computeTax(amount);

        assertEquals(10, actualTax, 0.005);
    }

}