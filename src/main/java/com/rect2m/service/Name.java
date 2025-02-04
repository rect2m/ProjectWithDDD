package com.rect2m.service;

public final class Name {
    private final String firstName;
    private final String lastName;

    public Name(String firstName, String lastName) {
        if (firstName.isBlank() || lastName.isBlank()) {
            throw new IllegalArgumentException("Ім'я та прізвище не можуть бути порожніми");
        }
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}

