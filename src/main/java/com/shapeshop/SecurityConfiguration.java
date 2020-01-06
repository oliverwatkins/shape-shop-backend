package com.shapeshop;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration  
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {  
      
//	@Override  
//	public void configure(HttpSecurity http) throws Exception {  
//       http  
//       .authorizeRequests()  
//       .antMatchers( "/public/**").permitAll()  
//       .anyRequest().authenticated()  
//           .and()  
//       .formLogin()  
//           .loginPage("/login.html")  
//           .failureUrl("/login-error.html")  
//           .permitAll();  
//	}
	
	
	
    @Override  
    public void configure(HttpSecurity http) throws Exception {  
        http.antMatcher("/**")  
            .authorizeRequests()  
            .antMatchers("/", "/login**").permitAll()  
            .anyRequest().authenticated()  
            .and()  
            .oauth2Login();  
    } 
      
    @Override  
    protected void configure(AuthenticationManagerBuilder auth) throws Exception { 
    	
    	System.out.println("configure(AuthenticationManagerBuilder auth)");
        
    	auth.inMemoryAuthentication()  
            .withUser("user")  
            .password("{noop}pass") // Spring Security 5 requires specifying the password storage format  
            .roles("USER");  
    }  
      
}