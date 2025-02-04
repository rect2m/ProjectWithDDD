package com.rect2m.Entities;

import com.rect2m.VO.OrderItemDetails;
import com.rect2m.VO.Money;
import com.rect2m.service.OrderStatus;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {
    private final UUID id;
    private final List<OrderItemDetails> items;
    private Money totalPrice;
    private OrderStatus status;

    public Order(UUID id) {
        this.id = id;
        this.items = new ArrayList<>();
        this.totalPrice = new Money("USD", BigDecimal.ZERO);
        this.status = OrderStatus.NEW;
    }

    public void addItem(OrderItemDetails item) {
        items.add(item);
        recalculateTotalPrice();
    }

    public void recalculateTotalPrice() {
        Money total = new Money("USD", BigDecimal.ZERO);
        for (OrderItemDetails item : items) {
            total = total.add(item.getPrice().multiply(item.getQuantity()));
        }
        this.totalPrice = total;
    }

    public UUID getId() {
        return id;
    }

    public List<OrderItemDetails> getItems() {
        return new ArrayList<>(items);
    }

    public Money getTotalPrice() {
        return totalPrice;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void changeStatus(OrderStatus newStatus) {
        if (this.status == OrderStatus.SHIPPED && newStatus != OrderStatus.DELIVERED) {
            throw new IllegalStateException("Перехід у цей статус неможливий");
        }
        this.status = newStatus;
    }

    public boolean isCompleted() {
        return this.status == OrderStatus.DELIVERED;
    }
}
