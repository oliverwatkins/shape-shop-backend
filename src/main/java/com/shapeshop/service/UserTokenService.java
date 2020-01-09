package com.shapeshop.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shapeshop.JWTUtil;
import com.shapeshop.SecurityConstants;
import com.shapeshop.model.User;
import com.shapeshop.model.UserToken;
import com.shapeshop.repository.UserTokenRepository;


@Service
@Transactional
public class UserTokenService {

    @Autowired
    private UserTokenRepository repository;

    @Autowired
    private UserService userService;

    public UserToken findByToken(String token) {
        return repository.findByToken(token);
    }

    public UserToken createToken(String userEmail) {
        var user = userService.findByEmail(userEmail);

        return createUserToken(user);
    }

    public UserToken createToken(User user, Date expiresAt) {
        return createUserToken(user, expiresAt);
    }

    private UserToken createUserToken(User user) {
        var expiresAt = new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME);
        return createUserToken(user, expiresAt);
    }

    private UserToken createUserToken(User user, Date expiresAt) {
        var status = user.isActive() ? SecurityConstants.ACTIVE_USER : SecurityConstants.NOT_VERIFIED_USER;
        var jwtToken = JWTUtil.createToken(
            user.getRole().toString(),
            status,
            expiresAt
        );
        
        UserToken userToken = new UserToken(user, expiresAt, jwtToken);

        repository.save(userToken);

        return userToken;
    }

    public void delete(String token) {
    	throw new RuntimeException("TODO");
//        repository.deleteById(token);
    }
}
