package com.shapeshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shapeshop.entity.CompanyEntity;
import com.shapeshop.entity.OrderEntity;
import com.shapeshop.repository.CompanyRepository;
import com.shapeshop.service.OrderService;


@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@Autowired
	private CompanyRepository companyR;

	@CrossOrigin
	@PostMapping(value = "/orders")
	public ResponseEntity<Object> order(@RequestBody OrderEntity order) {
		System.out.println("post order !!!");
		OrderEntity s = orderService.createOrder(order);
		
		System.out.println("created order : " + s);
		
		
		return new ResponseEntity<>(s, HttpStatus.OK);
	}
	
	@CrossOrigin
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(value = "/{companyName}/orders")
	public OrderEntity[]  getOrders(@PathVariable("companyName") String companyName) {
		
		
		System.out.println("companyName " + companyName);
		
		CompanyEntity c = companyR.findByName(companyName);
		
		System.out.println("getOrders ! for company " + c);
		List<OrderEntity> itemList = orderService.getOrdersByCompany(c);
		OrderEntity[] orders = new OrderEntity[itemList.size()];
		return orderService.getOrdersByCompany(c).toArray(orders);
	}
}
