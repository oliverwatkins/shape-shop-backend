package com.shapeshop.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shapeshop.entity.OrderEntity;
import com.shapeshop.entity.ProductEntity;

public interface OrderRepository extends CrudRepository<OrderEntity, Long>{

    public OrderEntity findById(long id);
    
    public List<OrderEntity> findByDescription(String lastName);
	
}
