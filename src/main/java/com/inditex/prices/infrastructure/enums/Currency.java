package com.inditex.prices.infrastructure.enums;

public enum Currency {

    EUR("EUR"),
    USD("USD"),
    GBP("GBP");

    public final String text;

    Currency(String text) {
        this.text = text;
    }
}
