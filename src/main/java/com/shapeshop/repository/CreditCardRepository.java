package com.shapeshop.repository;

import org.springframework.data.repository.CrudRepository;

import com.shapeshop.entity.CreditCardEntity;

public interface CreditCardRepository extends CrudRepository<CreditCardEntity, Long>{

    public CreditCardEntity findById(long id);
    
//    public List<ProductEntity> findByName(String lastName);
	
}
