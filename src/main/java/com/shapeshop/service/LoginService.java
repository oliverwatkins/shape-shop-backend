//package com.shapeshop.service;
//
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.shapeshop.entity.UserEntity;
//
//
//
//@Service
//public class LoginService {
//    private static final Logger LOGGER = LoggerFactory.getLogger(LoginService.class);
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private PasswordValidationService passwordValidationService;
//
//    
//    public UserEntity login(String email, String password) {
//    	
//    	
//        UserEntity user = findValidUser(email);
//
//
//        validatePassword(user, password);
//    	System.out.println("LOG IN SUCCESS!!!");
//
//        return user;
//    }
//
//    private void validatePassword(UserEntity user, String password) {
//    	
//        if (!passwordValidationService.isPasswordMatch(user, password)) {
//            LOGGER.warn("Login failed. Invalid password received for " + user.getEmail());
//            throw new RuntimeException("ExceptionCode.UNAUTHORIZED");
//        }
//    }
//
//    private UserEntity findValidUser(String email) {
//        UserEntity user = userService.findByEmail(email);
//
//        if (user != null) {
//            return user;
//        }
//
//        LOGGER.warn("Login failed. No user found for email: " + email);
//
//        throw new RuntimeException("ExceptionCode.UNAUTHORIZED");
//    }
//}
