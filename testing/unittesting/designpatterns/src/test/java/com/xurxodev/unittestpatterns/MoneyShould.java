package com.xurxodev.unittestpatterns;

import com.xurxodev.unittestpatterns.common.Currencies;
import com.xurxodev.unittestpatterns.common.MoneyBuilder;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Currency;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MoneyShould {
    @Test
    public void return_display_name_as_amount_concat_with_currency_symbol(){

        Money money = new MoneyBuilder()
                .withAmount("100.00")
                .withCurrency(Currencies.EURO())
                .build();

        assertThat(money.getDisplayName(), is("100.00 €"));
    }
}
