package com.shapeshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shapeshop.entity.CompanyEntity;
import com.shapeshop.entity.OrderEntity;
import com.shapeshop.repository.CompanyRepository;
import com.shapeshop.service.OrderService;

/**
 * Order Controller. Create orders, get list of orders
 */
@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private CompanyRepository companyR;


	/**
	 * creates an order
	 *
	 * @param order order entity
	 * @param companyName company
	 * @return http response
	 */
	@CrossOrigin
	@PostMapping(value = "/{companyName}/orders")
	public ResponseEntity<Object> order(@RequestBody OrderEntity order, @PathVariable("companyName") String companyName) {
		System.out.println("-->>> post order for company " + companyName + " : " + order);

		CompanyEntity c = companyR.findByName(companyName);

		order.setCompany(c);

		OrderEntity o = orderService.createOrder(order);

		System.out.println("-->>> created order ");

		return new ResponseEntity<>(o, HttpStatus.OK);
	}

	/**
	 * Get a list of orders for company.
	 *
	 * @param companyName
	 * @return
	 */
	@CrossOrigin
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(value = "/{companyName}/orders")
	public OrderEntity[] getOrders(@PathVariable("companyName") String companyName) {

		System.out.println("-->>> companyName " + companyName);

		CompanyEntity c = companyR.findByName(companyName);

		System.out.println("-->>> getOrders for company " + c);

		List<OrderEntity> itemList = orderService.getOrdersByCompany(c);

		return itemList.toArray(new OrderEntity[itemList.size()]);
	}
}
