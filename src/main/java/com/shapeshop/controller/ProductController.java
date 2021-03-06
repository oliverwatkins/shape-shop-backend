package com.shapeshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

	@CrossOrigin
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/{companyName}/products/{id}")
	public ResponseEntity<?> updateProduct(@RequestBody ProductEntity product, @PathVariable("id") Long id, @PathVariable("companyName") String companyName ) {
		productService.updateProduct(product, id);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@CrossOrigin
	@PostMapping("/products")
	public ResponseEntity<?> newProduct(@RequestBody ProductEntity product) {
		ProductEntity s = productService.createProduct(product);
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

	@GetMapping(value = "/{companyName}/products/{id}")
	public ProductEntity getProductsById(@PathVariable("companyName") String companyName, @PathVariable("id") long id) {
		ProductEntity item = productService.getProductById(id);
		return item;
	}

	@DeleteMapping(value = "/{companyName}/products/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void deleteProductById(@PathVariable("id") long id) {
		productService.deleteProduct(id);
	}

//	@DeleteMapping(value = "/{companyName}/products")
//	public void deleteShapes(@RequestBody ProductEntity shape) {
//		productService.deleteProduct(shape);
//	}
}
