package com.shapeshop.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
//@Data
@Entity
@Table(name = "category")
public class CategoryEntity {

    @Id
    @Column(name = "cat_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false, updatable = false)
    private CompanyEntity company = new CompanyEntity();

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private List<ProductCategoryEntity> productCategory = new ArrayList<>();

    @Column(name = "name")
    private String name;

    protected CategoryEntity() {
    }

    public CategoryEntity(String name, CompanyEntity company) {
        this.name = name;
        this.company = company;
    }

}
