package com.company.other;

public enum Gender {
    MAN("Man"),
    WOMAN("Woman");

    private String value;

    Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
