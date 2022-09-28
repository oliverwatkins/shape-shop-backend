package com.shapeshop.entity.dto;

import java.math.BigDecimal;

public class ProductDto {

    public long id;
    public String name;
    public BigDecimal price;
    public String description;
    public String imageFilename;

    public ProductDto(long id, String name, BigDecimal price, String description, String imageFilename) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageFilename = imageFilename;
    }
}
