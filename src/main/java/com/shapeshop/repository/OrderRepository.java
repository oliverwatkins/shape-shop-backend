package com.shapeshop.repository;

import com.shapeshop.entity.CompanyEntity;
import com.shapeshop.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<OrderEntity, Long>{

    public OrderEntity findById(long id);

	public List<OrderEntity> findByCompany(CompanyEntity company);
}
