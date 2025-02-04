package com.rect2m.service;

public final class Email {
    private final String value;

    public Email(String value) {
        if (!value.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Невірний формат email");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

