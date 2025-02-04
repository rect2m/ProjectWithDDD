package com.rect2m.Aggregates;

import com.rect2m.Entities.Order;
import com.rect2m.VO.OrderItemDetails;
import com.rect2m.service.OrderStatus;

public class OrderAggregate {
    private final Order rootOrder;

    public OrderAggregate(Order order) {
        this.rootOrder = order;
    }

    public void addItem(OrderItemDetails item) {
        rootOrder.addItem(item);
    }

    public void removeItem(OrderItemDetails item) {
        if (rootOrder.getStatus() == OrderStatus.SHIPPED) {
            throw new IllegalStateException("Замовлення відправлене, змінювати товари не можна");
        }
        rootOrder.getItems().remove(item);
        rootOrder.recalculateTotalPrice();
    }
}
