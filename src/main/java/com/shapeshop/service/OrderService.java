package com.shapeshop.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.shapeshop.entity.CompanyEntity;
import com.shapeshop.entity.OrderEntity;
import com.shapeshop.entity.OrderItemEntity;
import com.shapeshop.repository.AddressRepository;
import com.shapeshop.repository.CreditCardRepository;
import com.shapeshop.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	CrudRepository<OrderItemEntity, Long> orderItemRepository;

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

		if (oitems.size() == 0) {
			throw new RuntimeException(" Order has no order items. ");
		}

		for (OrderItemEntity orderItemEntity : oitems) {

			try {
				orderItemRepository.save(orderItemEntity);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		orderRepository.save(order);
		return order;
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

	public void deleteOrder(long id) {
		orderRepository.deleteById(id);
	}

	public void deleteOrder(OrderEntity shape) {
		orderRepository.delete(shape);
	}

	public OrderEntity getOrderById(long id) {
		return orderRepository.findById(id);
	}
}
