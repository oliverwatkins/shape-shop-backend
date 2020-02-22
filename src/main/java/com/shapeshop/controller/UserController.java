package com.shapeshop.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

	@PreAuthorize("hasAnyRole('ROLE_USER, ROLE_ADMIN')")
	@GetMapping(value = "/user")
	public String user() {
		return "user";  
	}
}
