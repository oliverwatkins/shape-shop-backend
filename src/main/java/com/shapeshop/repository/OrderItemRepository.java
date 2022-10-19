package com.shapeshop.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.shapeshop.entity.OrderItemEntity;
import org.springframework.transaction.annotation.Transactional;

public interface OrderItemRepository extends CrudRepository<OrderItemEntity, Long>{

    @Query(value = "TRUNCATE TABLE orders_item", nativeQuery = true)
    @Modifying
    @Transactional
    void truncate();
}
