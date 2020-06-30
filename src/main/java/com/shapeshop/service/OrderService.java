package com.shapeshop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shapeshop.entity.OrderEntity;
import com.shapeshop.entity.ProductEntity;
import com.shapeshop.entity.ShapeEntity;
import com.shapeshop.repository.ProductRepository;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class OrderService {

	@Autowired
	ProductRepository productRepository;

	public ProductEntity createProduct(ProductEntity product) {
		productRepository.save(product);
		return product;
	}

	public void deleteProduct(long id) {
		productRepository.deleteById(id);
	}
	public void deleteProduct(ProductEntity shape) {
		productRepository.delete(shape);
	}

	public List<OrderEntity> getAllOrders() {

//		getAllOrders
		
//		List<OrderEntity> result = StreamSupport.stream(productRepository.findAll().spliterator(), false)
//				.collect(Collectors.toList());

		List<OrderEntity> result = new ArrayList<OrderEntity>();
		
		return result;
	}

	public ProductEntity getProductById(long id) {
		return productRepository.findById(id);
	}

}
