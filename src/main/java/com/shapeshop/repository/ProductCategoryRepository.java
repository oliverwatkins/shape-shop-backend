package com.shapeshop.repository;

import com.shapeshop.entity.ProductCategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductCategoryRepository extends CrudRepository<ProductCategoryEntity, Long>{

    public ProductCategoryEntity findById(long id);

}
