package com.rect2m;

import static org.assertj.core.api.Assertions.*;
import com.rect2m.VO.Money;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    void shouldAddTwoMoneyObjects() {
        Money money1 = new Money("USD", BigDecimal.valueOf(50));
        Money money2 = new Money("USD", BigDecimal.valueOf(30));

        Money result = money1.add(money2);

        assertThat(result.getAmount()).isEqualByComparingTo("80.00");
    }

    @Test
    void shouldNotAllowAddingDifferentCurrencies() {
        Money usd = new Money("USD", BigDecimal.valueOf(50));
        Money eur = new Money("EUR", BigDecimal.valueOf(30));

        assertThatThrownBy(() -> usd.add(eur))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Валюти не співпадають");
    }

    @Test
    void shouldMultiplyMoneyCorrectly() {
        Money money = new Money("USD", BigDecimal.valueOf(20));

        Money result = money.multiply(3);

        assertThat(result.getAmount()).isEqualByComparingTo("60.00");
    }
}
