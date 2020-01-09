package com.shapeshop.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.shapeshop.model.User;


@Service
public class PasswordValidationService {

    private static final int PASSWORD_MIN_LENGTH = 5;

    private static final int PASSWORD_MAX_LENGTH = 50;

    public boolean isPasswordMatch(User user, String password) {
    	
    	System.out.println("user password is " + user.getPassword());
    	System.out.println("encryptPassword(password) " + encryptPassword(password));
    	
    	boolean b = user.getPassword().equals(encryptPassword(password));
    	System.out.println("b " + b);
    	
        return b;
    }

    public String encryptPassword(String password) {
        return DigestUtils.sha256Hex(password).toUpperCase();
    }

    public boolean isValidPassword(String password) {
        return StringUtils.isNotBlank(password) && password.length() >= PASSWORD_MIN_LENGTH &&
            password.length() <= PASSWORD_MAX_LENGTH;
    }
}
