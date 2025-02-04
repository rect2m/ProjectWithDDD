package com.rect2m.Entities;

import com.rect2m.VO.Money;
import com.rect2m.VO.ProductDetails;
import com.rect2m.service.Stock;
import java.math.BigDecimal;
import java.util.UUID;

public class Product {
    private final UUID id;
    private ProductDetails details;
    private Money price;
    private Stock stock;

    public Product(UUID id, ProductDetails details, Money price, Stock stock) {
        this.id = id;
        this.details = details;
        this.price = price;
        this.stock = stock;
    }

    public boolean isAvailable(int quantity) {
        return stock.getQuantity() >= quantity;
    }

    public void updatePrice(Money newPrice) {
        if (newPrice.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Ціна повинна бути більше 0");
        }
        this.price = newPrice;
    }

    public void reduceStock(int quantity) {
        if (quantity > stock.getQuantity()) {
            throw new IllegalStateException("Недостатньо товару на складі");
        }
        stock = stock.reduce(quantity);
    }
}

