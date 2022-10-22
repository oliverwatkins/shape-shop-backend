package com.shapeshop.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.shapeshop.entity.CompanyEntity;
import org.springframework.transaction.annotation.Transactional;

public interface CompanyRepository extends CrudRepository<CompanyEntity, Long>{

    public CompanyEntity findById(long id);
    
    public CompanyEntity findByName(String lastName);

    @Query(value = "TRUNCATE TABLE company", nativeQuery = true)
    @Modifying
    @Transactional
    void truncate();
}
