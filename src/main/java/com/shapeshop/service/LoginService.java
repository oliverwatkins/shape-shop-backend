package com.shapeshop.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shapeshop.model.User;



@Service
public class LoginService {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginService.class);

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordValidationService passwordValidationService;

    public User login(String email, String password) {
        User user = findValidUser(email);

        validatePassword(user, password);

        return user;
    }

    private void validatePassword(User user, String password) {
        if (!passwordValidationService.isPasswordMatch(user, password)) {
            LOGGER.warn("Login failed. Invalid password received for " + user.getEmail());
            throw new RuntimeException("ExceptionCode.UNAUTHORIZED");
        }
    }

    private User findValidUser(String email) {
        User user = userService.findByEmail(email);

        if (user != null) {
            return user;
        }

        LOGGER.warn("Login failed. No user found for email: " + email);

        throw new RuntimeException("ExceptionCode.UNAUTHORIZED");
    }
}
