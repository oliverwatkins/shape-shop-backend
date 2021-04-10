package com.shapeshop.security;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.shapeshop.entity.UserEntity;


@Service
public class PasswordUtils {
    public String encryptPassword(String password) {
        return DigestUtils.sha256Hex(password).toUpperCase();
    }
}
