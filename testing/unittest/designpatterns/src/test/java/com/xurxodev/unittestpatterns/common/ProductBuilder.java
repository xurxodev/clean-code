package com.xurxodev.unittestpatterns.common;

import com.xurxodev.unittestpatterns.Money;
import com.xurxodev.unittestpatterns.Product;

import java.util.Currency;

public class ProductBuilder {
    private String title = "Product example";
    private String amount = "";
    private Currency currency = Currencies.EURO();

    public ProductBuilder withTitle(String title){
        this.title = title;
        return this;
    }

    public ProductBuilder withAmount(String amount){
        this.amount = amount;
        return this;
    }

    public ProductBuilder withCurrency(Currency currency){
        this.currency = currency;
        return this;
    }

    public Product build(){
        Money price = new MoneyBuilder()
                .withAmount(amount)
                .withCurrency(currency)
                .build();

        Product product = new Product(title);

        if (amount!= null && !amount.isEmpty())
            product.ChangePrice(price);

        return product;
    }
}
