package com.rect2m.Aggregates;

import com.rect2m.Entities.Product;
import com.rect2m.VO.Money;

public class ProductAggregate {
    private final Product rootProduct;

    public ProductAggregate(Product product) {
        this.rootProduct = product;
    }

    public void updateStock(int quantity) {
        rootProduct.reduceStock(quantity);
    }

    public void changePrice(Money newPrice) {
        rootProduct.updatePrice(newPrice);
    }
}

