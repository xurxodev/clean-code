package com.xurxodev.unittestpatterns;

import com.xurxodev.unittestpatterns.common.Currencies;
import com.xurxodev.unittestpatterns.common.ProductBuilder;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProductShould {
    @Test
    public void is_on_sale_if_its_non_free_and_is_marked_as_on_sale() throws FreeProductOnSaleException {
        Product product = givenANonFreeProduct();

        product.markOnSale();

        assertThat(product.isOnSale(), is(true));
    }

    private Product givenANonFreeProduct() {
        return new ProductBuilder()
                    .withAmount("100.00")
                    .withCurrency(Currencies.EURO())
                    .build();
    }
}
