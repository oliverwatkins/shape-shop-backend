package com.shapeshop.repository;

import com.shapeshop.entity.CategoryEntity;
import com.shapeshop.entity.CompanyEntity;
import com.shapeshop.entity.ProductCategoryEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductCategoryRepository extends CrudRepository<ProductCategoryEntity, Long>{

    public ProductCategoryEntity findById(long id);

    @Query(value = "TRUNCATE TABLE product_category", nativeQuery = true)
    @Modifying
    @Transactional
    void truncate();
}
