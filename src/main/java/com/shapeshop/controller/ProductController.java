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

import com.shapeshop.entity.CompanyEntity;
import com.shapeshop.entity.ProductEntity;
import com.shapeshop.repository.CompanyRepository;
import com.shapeshop.service.ProductService;

/**
 * Product Controller
 */
@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CompanyRepository companyR;

	@CrossOrigin
	@GetMapping(value = "/test")
	public String test() {
		return "hello";
	}


	@PostMapping("/products")
	public ResponseEntity<?> newShape(@RequestBody ProductEntity shape) {
		ProductEntity s = productService.createProduct(shape);
		return new ResponseEntity<>(s, HttpStatus.OK);
	}

	@CrossOrigin
	@GetMapping(value = "/{companyName}/products")
	public ProductEntity[] getProducts(@PathVariable("companyName") String companyName) {

		CompanyEntity c = companyR.findByName(companyName);

		List<ProductEntity> itemList = productService.getProductsByCompany(c);

		System.out.println("Got products for company " + companyName + " . Number of products " + itemList.size());

		return itemList.toArray(new ProductEntity[itemList.size()]); //huh??
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

	@DeleteMapping(value = "/{companyName}/products")
	public void deleteShapes(@RequestBody ProductEntity shape) {
		productService.deleteProduct(shape);
	}
}
