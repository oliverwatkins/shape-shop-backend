package com.shapeshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AdminController {

	@GetMapping(value = "/admin")
	public String admin() {
		
		return "admin";  
	}
}
