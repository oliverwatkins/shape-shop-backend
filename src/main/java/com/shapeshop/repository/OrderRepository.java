package com.shapeshop.repository;

import java.util.List;

import com.shapeshop.entity.ProductEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.shapeshop.entity.CompanyEntity;
import com.shapeshop.entity.OrderEntity;
import org.springframework.transaction.annotation.Transactional;

public interface OrderRepository extends CrudRepository<OrderEntity, Long>{

    public OrderEntity findById(long id);

	public List<OrderEntity> findByCompany(CompanyEntity company);

    @Query(value = "TRUNCATE TABLE orders", nativeQuery = true)
    @Modifying
    @Transactional
    void truncate();
}
