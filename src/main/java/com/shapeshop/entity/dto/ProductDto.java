package com.shapeshop.entity.dto;

import java.math.BigDecimal;
import java.util.List;

public class ProductDto {

    public long id;
    public String name;
    public BigDecimal price;
    public String description;
    public String sashText;
    public String imageFilename;
    public List<CategoryDto> categories;

    public ProductDto() {}

    public ProductDto(long id, String name, BigDecimal price, String description, String imageFilename, String sashText, List<CategoryDto> cats) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageFilename = imageFilename;
        this.categories = cats;
        this.sashText = sashText;
    }
}
