package com.shapeshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import com.shapeshop.entity.User;
import com.shapeshop.model.LoggedUserInfo;
import com.shapeshop.service.LoginService;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private LoginService service;

    @Autowired
    private LoggedUserInfo userInfo;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        User user;

        try {
            user = service.login(name, password);
        } catch (Exception ex) {
        	
        	ex.printStackTrace();
        	
            throw new BadCredentialsException("wrong data received", ex);
        }

        var userRole = user.getRole().toString();
        userInfo.setRole(userRole);
        userInfo.setActive(user.isActive());

        var role = AuthorityUtils.commaSeparatedStringToAuthorityList(userRole);

        return new UsernamePasswordAuthenticationToken(name, null, role);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
