package com.xurxodev.unittestpatterns;

public class Country {
    private final String code;
    private final String name;

    public Country(String code, String name) {
        if (code == null || code.isEmpty()) throw new IllegalArgumentException("code is required");
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("name is required");

        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (!code.equals(country.code)) return false;
        return name.equals(country.name);

    }

    @Override
    public int hashCode() {
        int result = code.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
