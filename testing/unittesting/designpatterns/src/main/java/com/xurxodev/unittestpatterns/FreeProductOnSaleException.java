package com.xurxodev.unittestpatterns;

public class FreeProductOnSaleException extends Exception{
    public FreeProductOnSaleException() {
        super("A free product can not be on sale");
    }
}
