package com.shapeshop.entity.dto;

public class OrderItemDto {

    public ProductDto product;
    public long amount;

    public OrderItemDto(ProductDto product, long amount) {
        this.product = product;
        this.amount = amount;
    }
}
