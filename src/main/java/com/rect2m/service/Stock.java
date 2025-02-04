package com.rect2m.service;

public final class Stock {
    private final int quantity;

    public Stock(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Кількість не може бути від'ємною");
        }
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public Stock reduce(int amount) {
        if (amount > quantity) {
            throw new IllegalArgumentException("Недостатньо товару на складі");
        }
        return new Stock(quantity - amount);
    }
}
