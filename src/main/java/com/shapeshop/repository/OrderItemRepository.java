package com.shapeshop.repository;

import org.springframework.data.repository.CrudRepository;

import com.shapeshop.entity.OrderItemEntity;

public interface OrderItemRepository extends CrudRepository<OrderItemEntity, Long>{

}
