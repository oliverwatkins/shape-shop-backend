package com.shapeshop.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  
public class LoginController {  
      

    // Login form  
    @RequestMapping("/login.html")  
    public String login() {  
        return "login.html";  
    }  
    
    
    @RequestMapping("/securedPage")  
    public String securedPage(Model model,  
                              @RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient,  
                              @AuthenticationPrincipal OAuth2User oauth2User) {  
        model.addAttribute("userName", oauth2User.getName());  
        model.addAttribute("clientName", authorizedClient.getClientRegistration().getClientName());  
        model.addAttribute("userAttributes", oauth2User.getAttributes());  
        return "securedPage";  
    }  

    // Login form with error  
    @RequestMapping("/login-error.html")  
    public String loginError(Model model) {  
        model.addAttribute("loginError", true);  
        return "login.html";  
    }  

}