package com.shapeshop.repository;

import com.shapeshop.entity.CategoryEntity;
import com.shapeshop.entity.ProductCategoryEntity;
import com.shapeshop.entity.CompanyEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Long>{

    public CategoryEntity findById(long id);
    
    public CategoryEntity findByName(String lastName);

    public List<CategoryEntity> findByCompany(CompanyEntity company);

    @Query(value = "TRUNCATE TABLE category", nativeQuery = true)
    @Modifying
    @Transactional
    void truncate();


}
