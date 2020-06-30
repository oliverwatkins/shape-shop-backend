package com.shapeshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shapeshop.entity.ProductEntity;
import com.shapeshop.service.ProductService;


@RestController
public class ProductController {

	@Autowired
	private ProductService productService;


	@PostMapping("/products")
	public ResponseEntity<?> newShape(@RequestBody ProductEntity shape) {
		ProductEntity s = productService.createProduct(shape);
		return new ResponseEntity<>(s, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping(value = "/products")
	public ProductEntity[] shapes() {
		List<ProductEntity> itemList = productService.getAllProducts();
		ProductEntity[] array = new ProductEntity[itemList.size()];
		return productService.getAllProducts().toArray(array); //huh??
	}

	@GetMapping(value = "/products/{id}")
	public ProductEntity getProductsById(@PathVariable("id") long id) {
		ProductEntity item = productService.getProductById(id);
		return item;
	}

	@DeleteMapping(value = "/products/{id}")
	public void deleteShapesById(@PathVariable("id") long id) {
		productService.deleteProduct(id);
	}

	@DeleteMapping(value = "/products")
	public void deleteShapes(@RequestBody ProductEntity shape) {
		productService.deleteProduct(shape);
	}
}
