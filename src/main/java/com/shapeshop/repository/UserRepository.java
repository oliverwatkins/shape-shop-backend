package com.shapeshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.shapeshop.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

    User findByEmailIgnoreCase(String email);

    User findByMembershipId(String membershipId);

    boolean existsByEmailContainingIgnoreCase(String email);

    @Transactional
    void deleteByEmail(String email);
}
