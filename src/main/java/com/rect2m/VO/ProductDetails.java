package com.rect2m.VO;

public final class ProductDetails {
    private final String name;
    private final String description;
    private final Dimensions dimensions;

    public ProductDetails(String name, String description, Dimensions dimensions) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Назва товару не може бути порожньою");
        }
        this.name = name;
        this.description = description;
        this.dimensions = dimensions;
    }

    public String getShortDescription() {
        return name + ": " + description.substring(0, Math.min(description.length(), 50));
    }
}
