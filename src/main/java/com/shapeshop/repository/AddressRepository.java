package com.shapeshop.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shapeshop.entity.AddressEntity;
import com.shapeshop.entity.ProductEntity;

public interface AddressRepository extends CrudRepository<AddressEntity, Long>{

    public AddressEntity findById(long id);
    
//    public List<ProductEntity> findByName(String lastName);
	
}
