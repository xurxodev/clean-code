package com.xurxodev.unittestpatterns;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CountryShould {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void throw_exception_if_name_not_provided(){
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("name is required");

        new Country("es","");
    }
}
