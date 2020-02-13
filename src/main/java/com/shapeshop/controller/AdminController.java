package com.shapeshop.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AdminController {

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(value = "/admin")
	public String admin() {
		
		return "admin";  
	}
}
