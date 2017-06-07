package com.xurxodev.unittestpatterns;

import java.math.BigDecimal;
import java.util.Currency;

public class Money {
    private BigDecimal amount;
    private Currency currency;

    public Money(BigDecimal amount, Currency currency) {
        if (amount == null) throw new IllegalArgumentException("amount is required");
        if (currency == null) throw new IllegalArgumentException("currency is required");

        this.amount = amount;
        this.currency = currency;
    }

    public String getDisplayName(){
        return String.format("%s %s", amount.toString() ,currency.getSymbol());
    }

    public Double getAmount(){
        return amount.doubleValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money money = (Money) o;

        if (!amount.equals(money.amount)) return false;
        return currency.equals(money.currency);

    }

    @Override
    public int hashCode() {
        int result = amount.hashCode();
        result = 31 * result + currency.hashCode();
        return result;
    }
}
