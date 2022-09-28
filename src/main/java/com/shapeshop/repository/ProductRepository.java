package com.shapeshop.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shapeshop.entity.CompanyEntity;
import com.shapeshop.entity.ProductEntity;

public interface ProductRepository extends CrudRepository<ProductEntity, Long>{

    public ProductEntity findById(long id);
    
    public List<ProductEntity> findByName(String lastName);

	public List<ProductEntity> findByCompany(CompanyEntity company);

}
