package com.shapeshop.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shapeshop.entity.CompanyEntity;
import com.shapeshop.entity.OrderEntity;

public interface OrderRepository extends CrudRepository<OrderEntity, Long>{

    public OrderEntity findById(long id);

	public List<OrderEntity> findByCompany(CompanyEntity company);
    
//    public List<OrderEntity> findByName(String name);
	
}
