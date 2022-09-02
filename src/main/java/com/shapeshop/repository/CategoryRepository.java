package com.shapeshop.repository;

import com.shapeshop.entity.CategoryEntity;
import com.shapeshop.entity.CompanyEntity;
import com.shapeshop.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Long>{

    public CategoryEntity findById(long id);
    
    public CategoryEntity findByName(String lastName);

    public List<CategoryEntity> findByCompany(CompanyEntity company);
}
