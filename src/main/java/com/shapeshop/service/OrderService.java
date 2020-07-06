package com.shapeshop.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shapeshop.entity.OrderEntity;
import com.shapeshop.repository.OrderRepository;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class OrderService {

	@Autowired
	OrderRepository orderRepository;

	public OrderEntity createOrder(OrderEntity product) {
		orderRepository.save(product);
		return product;
	}

	public void deleteProduct(long id) {
		orderRepository.deleteById(id);
	}
	public void deleteProduct(OrderEntity shape) {
		orderRepository.delete(shape);
	}

	public List<OrderEntity> getAllOrders() {

//		getAllOrders
		
		List<OrderEntity> result = StreamSupport.stream(orderRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());

//		List<OrderEntity> result = new ArrayList<OrderEntity>();
		
		return result;
	}

	public OrderEntity getOrderById(long id) {
		return orderRepository.findById(id);
	}

}
