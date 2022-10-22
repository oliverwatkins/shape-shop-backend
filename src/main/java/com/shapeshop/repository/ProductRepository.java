package com.shapeshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.shapeshop.entity.CompanyEntity;
import com.shapeshop.entity.ProductEntity;
import org.springframework.transaction.annotation.Transactional;

public interface ProductRepository extends CrudRepository<ProductEntity, Long>{

    public ProductEntity findById(long id);
    
    public List<ProductEntity> findByName(String lastName);

	public List<ProductEntity> findByCompany(CompanyEntity company);

    @Query(value = "TRUNCATE TABLE product", nativeQuery = true)
    @Modifying
    @Transactional
    void truncate();


}
