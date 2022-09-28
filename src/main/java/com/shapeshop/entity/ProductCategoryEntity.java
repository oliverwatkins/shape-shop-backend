package com.shapeshop.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
@Getter
@Setter
//@Data
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

//@Entity
//@PrimaryKeyJoinColumn
//@IdClass(CompositeKey.class)
//public class EntityExample {
//    @Id
//    private int column1;
//    @Id
//    private int column2;
//    @Id
//    private int column3;
//}
