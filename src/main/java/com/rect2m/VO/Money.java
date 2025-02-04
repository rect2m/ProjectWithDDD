package com.rect2m.VO;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class Money {
    private final String currency;
    private final BigDecimal amount;

    public Money(String currency, BigDecimal amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public Money add(Money other) {
        if (!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("Валюти не співпадають");
        }
        return new Money(currency, amount.add(other.amount));
    }

    public Money subtract(Money other) {
        if (!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("Валюти не співпадають");
        }
        return new Money(currency, amount.subtract(other.amount));
    }

    public boolean isEqual(Money other) {
        return this.currency.equals(other.currency) && this.amount.equals(other.amount);
    }

    public String format() {
        return currency + amount.setScale(2, RoundingMode.HALF_UP);
    }

    public Money multiply(int multiplier) {
        return new Money(this.currency, this.amount.multiply(BigDecimal.valueOf(multiplier)));
    }

    public BigDecimal getAmount() {
        return amount;
    }
}