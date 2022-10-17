package com.shapeshop.service;

import com.shapeshop.ShapeShopException;
import com.shapeshop.entity.CompanyEntity;
import com.shapeshop.entity.OrderEntity;
import com.shapeshop.entity.OrderItemEntity;
import com.shapeshop.entity.ProductEntity;
import com.shapeshop.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class OrderService {

	@Autowired
	private CompanyRepository companyRep;

	@Autowired
	CrudRepository<OrderItemEntity, Long> orderItemRepository;

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	CreditCardRepository creditCardRepository;

	public OrderEntity createOrder(OrderEntity order) throws ShapeShopException {

		if (order.getAddressEntity() != null)
			addressRepository.save(order.getAddressEntity());

		if (order.getCreditCardEntity() != null)
			creditCardRepository.save(order.getCreditCardEntity());

		List<OrderItemEntity> oitems = order.getOrderItems();

		if (oitems.size() == 0) {
			throw new ShapeShopException(" Order has no order items. ", ShapeShopException.ErrorType.ORDER_HAS_NO_ORDER_ITEMS);
		}

		for (OrderItemEntity orderItemEntity : oitems) {
			long prodId = orderItemEntity.getProduct().getId();

			ProductEntity pe = productRepository.findById(prodId);

			if (pe == null) {
				throw new ShapeShopException(" Product id " + prodId + " is not associated with any company ", ShapeShopException.ErrorType.PROD_NOT_FOUND);
			}

			if (!order.getCompany().getName().equals(pe.getCompany().getName())) {
				throw new ShapeShopException(" Product id belongs to wrong company. Order company " +
						order.getCompany().getName() + " Prod id company " +
						pe.getCompany().getName(), ShapeShopException.ErrorType.PROD_ID_BELONGS_TO_WRONG_COMPANY);
			}

			orderItemRepository.save(orderItemEntity);
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
