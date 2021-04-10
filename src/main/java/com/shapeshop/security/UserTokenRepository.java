


//DO NOT DELETE THIS!!!

//package com.shapeshop.repository;


//
//import java.util.Date;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.shapeshop.entity.UserToken;
//
//public interface UserTokenRepository extends JpaRepository<UserToken, String> {
//    UserToken findByToken(String token);
//
//    @Transactional
//    @Modifying
//    @Query("delete from UserToken where expiresAt < ?1")
//    int deleteExpiredToken(Date now);
//}
