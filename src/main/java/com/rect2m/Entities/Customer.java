package com.rect2m.Entities;

import com.rect2m.VO.Address;
import com.rect2m.service.Email;
import java.util.List;
import java.util.UUID;
import javax.lang.model.element.Name;

public class Customer {
    private final UUID id;
    private Name name;
    private Email email;
    private Address address;
    private List<Order> orders;

    public Customer(UUID id, Name name, Email email, Address address, List<Order> orders) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.orders = orders;
    }

    public void changeAddress(Address newAddress) {
        this.address = newAddress;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public boolean hasActiveOrders() {
        return orders.stream().anyMatch(order -> !order.isCompleted());
    }
}
