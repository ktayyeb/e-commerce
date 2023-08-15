package com.example.ecommerce.util;

public enum Roles {
    Buyer("buyer"),
    Seller("seller");

    private final String value;

    Roles(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
