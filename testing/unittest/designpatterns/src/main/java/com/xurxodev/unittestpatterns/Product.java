package com.xurxodev.unittestpatterns;

public class Product {
    String title;
    Money price ;
    boolean onSale = false;

    public Product(String title) {
        if (title == null || title.isEmpty()) throw new IllegalArgumentException("title is required");

        this.title = title;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public void ChangePrice(Money price){
        this.price = price;
    }

    public void markOnSale() throws FreeProductOnSaleException {
        if (price.getAmount() == 0)
            throw new FreeProductOnSaleException();
        else
            onSale = true;
    }
}
