package com.shapeshop.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shapeshop.entity.CompanyEntity;
import com.shapeshop.entity.OrderEntity;
import com.shapeshop.repository.AddressRepository;
import com.shapeshop.repository.OrderRepository;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class OrderService {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	AddressRepository addressRepository;

	
	public OrderEntity createOrder(OrderEntity product) {
		
		addressRepository.save(product.getAddressEntity());
		
		orderRepository.save(product);
		return product;
	}

	public void deleteOrder(long id) {
		orderRepository.deleteById(id);
	}
	public void deleteOrder(OrderEntity shape) {
		orderRepository.delete(shape);
	}

	public List<OrderEntity> getAllOrders() {
		List<OrderEntity> result = StreamSupport.stream(orderRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return result;
	}
	
	public List<OrderEntity> getOrdersByCompany(CompanyEntity company) {
		List<OrderEntity> result = StreamSupport.stream(orderRepository.findByCompany(company).spliterator(), false)
				.collect(Collectors.toList());
		return result;
	}

	public OrderEntity getOrderById(long id) {
		return orderRepository.findById(id);
	}
}
