package com.shapeshop.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.shapeshop.entity.AddressEntity;
import org.springframework.transaction.annotation.Transactional;

public interface AddressRepository extends CrudRepository<AddressEntity, Long>{
    public AddressEntity findById(long id);

    @Query(value = "TRUNCATE TABLE address", nativeQuery = true)
    @Modifying
    @Transactional
    void truncate();
}
