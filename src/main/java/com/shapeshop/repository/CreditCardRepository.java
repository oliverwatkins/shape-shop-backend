package com.shapeshop.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.shapeshop.entity.CreditCardEntity;
import org.springframework.transaction.annotation.Transactional;

public interface CreditCardRepository extends CrudRepository<CreditCardEntity, Long>{

    public CreditCardEntity findById(long id);

    @Query(value = "TRUNCATE TABLE credit_card", nativeQuery = true)
    @Modifying
    @Transactional
    void truncate();
}
