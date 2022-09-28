package com.shapeshop.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "product_category")
public class ProductCategoryEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "cat_id", nullable = false, updatable = false)
    private CategoryEntity category = new CategoryEntity();

    public ProductCategoryEntity() {
    }
    public ProductCategoryEntity(CategoryEntity category) {
        this.category = category;
    }
}
