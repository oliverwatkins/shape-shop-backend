package com.shapeshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.shapeshop.entity.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, String> {

    UserEntity findByUserNameIgnoreCase(String userName);

    boolean existsByUserNameContainingIgnoreCase(String userName);

    @Transactional
    void deleteByUserName(String userName);

    @Query(value = "TRUNCATE TABLE users", nativeQuery = true)
    @Modifying
    @Transactional
    void truncate();
}
