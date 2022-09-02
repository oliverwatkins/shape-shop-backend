package com.shapeshop.entity;

import lombok.Data;

import javax.persistence.*;

@Data
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

    @Column(name = "name")
    private String name;

    protected CategoryEntity() {
    }

    public CategoryEntity(String name, CompanyEntity company) {
        this.name = name;
        this.company = company;
    }

}
