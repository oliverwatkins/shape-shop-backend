package com.shapeshop.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shapeshop.model.NewUserDTO;
import com.shapeshop.model.User;
import com.shapeshop.repository.UserRepository;



@Service
public class UserService {
	
    @Autowired
    private UserRepository repository;


    @Autowired
    private PasswordValidationService passwordValidationService;

    
    public User createUser(NewUserDTO newUser) {
    	String password = passwordValidationService.encryptPassword(newUser.getPassword());

        User user = new User(newUser.getRole(), newUser.getEmail(),password, newUser.getCustomerId(), newUser.getMembershipId(), newUser.getLocale());

        user = repository.save(user);
        
        return user;
    }

    public boolean isEmailRegistered(String email) {
        return repository.existsByEmailContainingIgnoreCase(email);
    }

    public User findByEmail(String email) {
        if (StringUtils.isEmpty(email)) {
            return null;
        }
        return repository.findByEmailIgnoreCase(email);
    }
}
