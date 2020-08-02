package com.shapeshop.service;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shapeshop.entity.UserEntity;
import com.shapeshop.repository.UserRepository;
import com.shapeshop.util.PasswordUtils;


@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository repository;

	@Override
	public User loadUserByUsername(String userName) throws UsernameNotFoundException {

//		if (StringUtils.isEmpty(userName)) {
//			return null;
//		}

		UserEntity u = repository.findByUserNameIgnoreCase(userName);
		
		if (u == null) {
			throw new UsernameNotFoundException("User Not Found");
		}

		SimpleGrantedAuthority a = new SimpleGrantedAuthority(u.getRole().toString());
		
		ArrayList<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		auths.add(a);
		
		return new User(u.getUserName(), u.getPassword(), auths);
	}
}