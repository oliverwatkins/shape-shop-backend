package com.shapeshop.repository;

import com.shapeshop.entity.CompanyEntity;
import com.shapeshop.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<ProductEntity, Long>{

    public ProductEntity findById(long id);
    
    public List<ProductEntity> findByName(String lastName);

	public List<ProductEntity> findByCompany(CompanyEntity company);

}
