package com.shapeshop.repository;

import org.springframework.data.repository.CrudRepository;

import com.shapeshop.entity.OrderEntity;

public interface OrderRepository extends CrudRepository<OrderEntity, Long>{

    public OrderEntity findById(long id);
    
//    public List<OrderEntity> findByName(String name);
	
}
