package com.xurxodev.unittestpatterns.common;

import java.util.Currency;

public class Currencies {
    public static Currency EURO(){
        return Currency.getInstance("EUR");
    }

    public static Currency DOLLAR(){
        return Currency.getInstance("USD");
    }
}
