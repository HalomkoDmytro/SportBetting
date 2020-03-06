package com.my.training.model.user;

public enum Currency {

    EUR,
    USD,
    HUF;

    public static Currency getCurrency(final String s) {
        switch (s) {
            case "EUR":
                return EUR;
            case "USD":
                return USD;
            case "HUF":
                return HUF;
            default:
                throw new IllegalArgumentException();
        }
    }
}
