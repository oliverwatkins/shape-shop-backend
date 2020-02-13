package com.shapeshop.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping(value = "/user")
	public String admin() {
		
		return "user";  
	}
}
