package com.shapeshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shapeshop.entity.OrderEntity;
import com.shapeshop.entity.ShapeEntity;
import com.shapeshop.service.OrderService;


@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@CrossOrigin
	@PostMapping(value = "/orders")
	public ResponseEntity<Object> order(@RequestBody OrderEntity order) {
		System.out.println("post order !!!");
		OrderEntity s = orderService.createOrder(order);
		return new ResponseEntity<>(s, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping(value = "/orders")
	public OrderEntity[]  getOrders() {
		
		System.out.println("getOrders !!!");
		List<OrderEntity> itemList = orderService.getAllOrders();
		OrderEntity[] orders = new OrderEntity[itemList.size()];
		return orderService.getAllOrders().toArray(orders);
	}
}
