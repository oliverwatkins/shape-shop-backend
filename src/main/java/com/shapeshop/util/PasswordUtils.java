package com.shapeshop.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.shapeshop.entity.UserEntity;


@Service
public class PasswordUtils {

    private static final int PASSWORD_MIN_LENGTH = 5;
    private static final int PASSWORD_MAX_LENGTH = 50;

    public boolean isPasswordMatch(UserEntity user, String password) {
    	boolean b = user.getPassword().equals(encryptPassword(password));
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
