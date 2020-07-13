package com.shapeshop.repository;

import org.springframework.data.repository.CrudRepository;

import com.shapeshop.entity.CompanyEntity;

public interface CompanyRepository extends CrudRepository<CompanyEntity, Long>{

    public CompanyEntity findById(long id);
    
    public CompanyEntity findByName(String lastName);
	
}
