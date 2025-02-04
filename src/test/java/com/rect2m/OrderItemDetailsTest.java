package com.rect2m;

import com.rect2m.VO.Money;
import com.rect2m.VO.OrderItemDetails;
import org.junit.jupiter.api.Test;
import java.util.UUID;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

class OrderItemDetailsTest {

    @Test
    void shouldCreateOrderItemDetailsCorrectly() {
        UUID productId = UUID.randomUUID();
        Money price = new Money("USD", BigDecimal.valueOf(100));

        OrderItemDetails item = new OrderItemDetails(productId, 2, price);

        assertThat(item.getProductId()).isEqualTo(productId);
        assertThat(item.getQuantity()).isEqualTo(2);
        assertThat(item.getPrice().getAmount()).isEqualByComparingTo("100.00");
    }

    @Test
    void shouldNotAllowQuantityLessThanOne() {
        UUID productId = UUID.randomUUID();
        Money price = new Money("USD", BigDecimal.valueOf(100));

        assertThatThrownBy(() -> new OrderItemDetails(productId, 0, price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Кількість повинна бути не менше 1");
    }
}
