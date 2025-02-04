package com.rect2m.VO;

public final class Address {
    private final String country;
    private final String city;
    private final String street;
    private final String postalCode;

    public Address(String country, String city, String street, String postalCode) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
    }

    public String format() {
        return street + ", " + city + ", " + country + ", " + postalCode;
    }
}

