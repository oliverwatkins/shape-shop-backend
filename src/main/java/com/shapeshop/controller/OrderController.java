package com.shapeshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shapeshop.entity.OrderEntity;
import com.shapeshop.service.OrderService;


@RestController
public class OrderController {

	
	@Autowired
	private OrderService orderService;
	
	
	@CrossOrigin
	@PostMapping(value = "/order")
	public ResponseEntity<Object> order() {
		
		System.out.println("here!!!!!!!!!!!!!!!!!!");
		
//		ShapeEntity s = shapeService.createShape(shape);
		return new ResponseEntity<>(HttpStatus.OK);
		
//		List<ProductEntity> itemList = productService.getAllProducts();
//		ProductEntity[] shapes2 = new ProductEntity[itemList.size()];
//		return productService.getAllProducts().toArray(shapes2);
	}
	
	@CrossOrigin
	@GetMapping(value = "/order")
	public OrderEntity[]  getOrders() {
		
		System.out.println("here2222!!!!!!!!!!!!!!!!!!");
		List<OrderEntity> itemList = orderService.getAllOrders();
		OrderEntity[] orders = new OrderEntity[itemList.size()];
		return orderService.getAllOrders().toArray(orders);
		
		
//		ShapeEntity s = shapeService.createShape(shape);
//		return new ResponseEntity<>(HttpStatus.OK);
		
//		List<ProductEntity> itemList = productService.getAllProducts();
//		ProductEntity[] shapes2 = new ProductEntity[itemList.size()];
//		return productService.getAllProducts().toArray(shapes2);
	}
	
	
	
}
