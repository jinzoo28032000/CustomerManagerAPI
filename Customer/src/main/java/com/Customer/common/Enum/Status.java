package com.Customer.common.Enum;

public enum Status {
    ACTIVE("O-Active"),
    INACTIVE("1-Inactive");

    private String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
