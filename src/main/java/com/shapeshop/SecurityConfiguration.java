package com.shapeshop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.shapeshop.model.LoggedUserInfo;
import com.shapeshop.service.UserTokenService;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private final LoggedUserInfo userInfo;
	private final UserTokenService userTokenService;
	private final MyAuthenticationProvider authProvider;

	public SecurityConfiguration(MyAuthenticationProvider authProvider, LoggedUserInfo userInfo,
			UserTokenService userTokenService,
			@Value("${management.endpoint.health.whitelist.lb}") String healthcheckWhitelistLB,
			@Value("${management.endpoint.health.whitelist.remote}") String healthcheckWhitelistIp) {
		this.authProvider = authProvider;
		this.userInfo = userInfo;
		this.userTokenService = userTokenService;

	}

//    @Override  
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception { 
//    	
//    	System.out.println("configure(AuthenticationManagerBuilder auth)");
//        
//    	auth.inMemoryAuthentication()  
//            .withUser("user")  
//            	.password("{noop}pass") // Spring Security 5 requires specifying the password storage format  
//            	.roles("USER").and()
//            .withUser("admin")
//            	.password("{noop}pass")
//            	.roles("ADMIN"); 
//    }  

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/admin").hasRole("ADMIN").antMatchers("/user").hasAnyRole("USER", "ADMIN")
				.antMatchers("/shapes").hasAnyRole("USER", "ADMIN").antMatchers("/").permitAll().and().formLogin();
	}

}