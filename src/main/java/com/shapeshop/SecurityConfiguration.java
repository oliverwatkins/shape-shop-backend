package com.shapeshop;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration  
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {  
      

	
	
	
      
    @Override  
    protected void configure(AuthenticationManagerBuilder auth) throws Exception { 
    	
    	System.out.println("configure(AuthenticationManagerBuilder auth)");
        
    	auth.inMemoryAuthentication()  
            .withUser("user")  
            	.password("{noop}pass") // Spring Security 5 requires specifying the password storage format  
            	.roles("USER").and()
            .withUser("admin")
            	.password("{noop}pass")
            	.roles("ADMIN"); 
    	
    	
    }  
    
    
	@Override  
	public void configure(HttpSecurity http) throws Exception {  
		
		
		
	       http  
           .authorizeRequests()  
           .antMatchers( "/admin").hasRole("ADMIN") 
           .antMatchers( "/user").hasAnyRole("USER", "ADMIN") 
           .antMatchers( "/").permitAll()
           .and().formLogin();
	       
           
           
//           .anyRequest().authenticated()  
//               .and()  
//           .formLogin()  
//               .loginPage("/login.html")  
//               .failureUrl("/login-error.html")  
//               .permitAll()  
//               .and()
//	       .logout()
//	       		.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");
		
		

	}
      
}