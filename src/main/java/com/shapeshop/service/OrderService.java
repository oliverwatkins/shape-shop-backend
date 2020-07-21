package com.shapeshop.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shapeshop.entity.CompanyEntity;
import com.shapeshop.entity.OrderEntity;
import com.shapeshop.entity.OrderItemEntity;
import com.shapeshop.repository.AddressRepository;
import com.shapeshop.repository.CreditCardRepository;
import com.shapeshop.repository.OrderItemRepository;
import com.shapeshop.repository.OrderRepository;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class OrderService {

	@Autowired
	OrderItemRepository orderItemRepository;
	
	@Autowired
	OrderRepository orderRepository;

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	CreditCardRepository creditCardRepository;
	
	public OrderEntity createOrder(OrderEntity order) {

		if (order.getAddressEntity() != null)
			addressRepository.save(order.getAddressEntity());
		
		if (order.getCreditCardEntity() != null)
			creditCardRepository.save(order.getCreditCardEntity());
		
		
		List<OrderItemEntity> oitems = order.getOrderItems();
		System.out.println("-->>> number of order items " + oitems.size() + " ");

		for (OrderItemEntity orderItemEntity : oitems) {
			
			System.out.println("-->>> orderItemEntity " + orderItemEntity);
			orderItemRepository.save(orderItemEntity);
		}
		
		if (oitems.size() == 0) {
			throw new RuntimeException("oitems.size() == 0 ");
		}
		
		orderRepository.save(order);
		return order;
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
