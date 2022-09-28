package com.shapeshop.repository;

import com.shapeshop.entity.CategoryEntity;
import com.shapeshop.entity.CompanyEntity;
import com.shapeshop.entity.ProductCategoryEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductCategoryRepository extends CrudRepository<ProductCategoryEntity, Long>{

    public ProductCategoryEntity findById(long id);
    
//    public ProductCategoryEntity findByName(String lastName);

//    public List<ProductCategoryEntity> findByCompany(CompanyEntity company);
}
