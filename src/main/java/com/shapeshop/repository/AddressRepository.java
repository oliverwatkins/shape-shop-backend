package com.shapeshop.repository;

import org.springframework.data.repository.CrudRepository;

import com.shapeshop.entity.AddressEntity;

public interface AddressRepository extends CrudRepository<AddressEntity, Long>{
    public AddressEntity findById(long id);
}
