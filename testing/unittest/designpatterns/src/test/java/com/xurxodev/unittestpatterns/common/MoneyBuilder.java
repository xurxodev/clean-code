package com.xurxodev.unittestpatterns.common;

import com.xurxodev.unittestpatterns.Money;

import java.math.BigDecimal;
import java.util.Currency;

public class MoneyBuilder {
    private String amount;
    private Currency currency;

    public MoneyBuilder withAmount(String amount){
        this.amount = amount;
        return this;
    }

    public MoneyBuilder withCurrency(Currency currency){
        this.currency = currency;
        return this;
    }

    public Money build(){
        return new Money(new BigDecimal(amount), currency);
    }
}
