package com.rect2m.VO;

import java.util.UUID;

public final class OrderItemDetails {
    private final UUID productId;
    private final int quantity;
    private final Money price;

    public OrderItemDetails(UUID productId, int quantity, Money price) {
        if (quantity < 1) {
            throw new IllegalArgumentException("Кількість повинна бути не менше 1");
        }
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    public UUID getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public Money getPrice() {
        return price;
    }
}
