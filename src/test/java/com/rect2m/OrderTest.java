package com.rect2m;

import com.rect2m.Entities.Order;
import com.rect2m.VO.Money;
import com.rect2m.VO.OrderItemDetails;
import com.rect2m.service.OrderStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OrderTest {

    private Order order;
    private OrderItemDetails item1;
    private OrderItemDetails item2;

    @BeforeEach
    void setUp() {
        order = new Order(UUID.randomUUID());

        UUID productId1 = UUID.randomUUID();
        UUID productId2 = UUID.randomUUID();
        Money price1 = new Money("USD", BigDecimal.valueOf(50));
        Money price2 = new Money("USD", BigDecimal.valueOf(30));

        item1 = new OrderItemDetails(productId1, 2, price1);
        item2 = new OrderItemDetails(productId2, 1, price2);
    }

    @Test
    void shouldAddItemsToOrder() {
        order.addItem(item1);
        order.addItem(item2);

        assertThat(order.getItems()).hasSize(2);
    }

    @Test
    void shouldCalculateTotalPriceCorrectly() {
        order.addItem(item1); // 50 * 2 = 100
        order.addItem(item2); // 30 * 1 = 30

        order.recalculateTotalPrice();

        assertThat(order.getTotalPrice().getAmount()).isEqualByComparingTo("130.00");
    }

    @Test
    void shouldNotAllowInvalidStatusTransition() {
        // GIVEN: Створюємо замовлення зі статусом SHIPPED
        Order order = new Order(UUID.randomUUID());
        order.changeStatus(OrderStatus.SHIPPED);

        // WHEN & THEN: Спроба змінити статус на щось інше (наприклад, PROCESSING) має викликати виняток
        Exception exception = assertThrows(IllegalStateException.class,
                () -> order.changeStatus(OrderStatus.SHIPPED));

        assertEquals("Перехід у цей статус неможливий", exception.getMessage());
    }

}
