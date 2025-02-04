package com.rect2m.Aggregates;

import com.rect2m.Entities.Customer;
import com.rect2m.Entities.Order;
import com.rect2m.VO.Address;

public class CustomerAggregate {
    private final Customer rootCustomer;

    public CustomerAggregate(Customer customer) {
        this.rootCustomer = customer;
    }

    public void addOrder(Order order) {
        rootCustomer.addOrder(order);
    }

    public void changeAddress(Address newAddress) {
        if (rootCustomer.hasActiveOrders()) {
            throw new IllegalStateException("Не можна змінювати адресу при активних замовленнях");
        }
        rootCustomer.changeAddress(newAddress);
    }
}

