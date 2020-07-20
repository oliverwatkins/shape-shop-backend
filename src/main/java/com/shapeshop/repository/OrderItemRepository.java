package com.shapeshop.repository;

import org.springframework.data.repository.CrudRepository;

import com.shapeshop.entity.OrderItemEntity;

public interface OrderItemRepository extends CrudRepository<OrderItemEntity, Long>{

//    public OrderEntity findById(long id);

//	public List<OrderItemEntity> findByCompany(CompanyEntity company);
    
//    public List<OrderEntity> findByName(String name);
	
}
