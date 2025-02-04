package com.rect2m.service;

public enum OrderStatus {
    NEW, CONFIRMED, SHIPPED, DELIVERED;

    public boolean isTransitionAllowed(OrderStatus newStatus) {
        return switch (this) {
            case NEW -> newStatus == CONFIRMED;
            case CONFIRMED -> newStatus == SHIPPED;
            case SHIPPED -> newStatus == DELIVERED;
            case DELIVERED -> false;
        };
    }
}

