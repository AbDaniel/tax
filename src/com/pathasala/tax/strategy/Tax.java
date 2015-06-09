package com.pathasala.tax.strategy;

public class Tax {

    private double percentage;

    public Tax(double percentage) {
        this.percentage = percentage;
    }

    public double computeTax(double amount) {
        return amount * percentage / 100;
    }

}
