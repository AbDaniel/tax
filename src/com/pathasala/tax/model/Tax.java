package com.pathasala.tax.model;

public class Tax {

    private double percentage;

    public Tax(double percentage) {
        this.percentage = percentage;
    }

    public double computeTax(double amount) {
        return amount * percentage / 100;
    }

}
