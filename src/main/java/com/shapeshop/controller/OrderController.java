package com.shapeshop.controller;

import java.util.List;

import com.shapeshop.ErrorUtil;
import com.shapeshop.ShapeShopException;
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
 * Order Controller. Create orders, get list of orders etc.
 */
@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private CompanyRepository companyRep;

	/**
	 * Create order
	 */
	@CrossOrigin
	@PostMapping(value = "/{companyName}/orders")
	public ResponseEntity<Object> order(@RequestBody OrderEntity order, @PathVariable("companyName") String companyName) {

		CompanyEntity c = companyRep.findByName(companyName);
		order.setCompany(c);
		OrderEntity o;
		try {
			o = orderService.createOrder(order);
		} catch (ShapeShopException e) {
			e.printStackTrace();

			ResponseEntity response = ErrorUtil.getResponseEntity(e);
			return response;

		} catch (Throwable t) {
			t.printStackTrace();
			return new ResponseEntity<>("internal server error 2", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(o, HttpStatus.OK);
	}

	/**
	 * Get orders for company
	 */
	@CrossOrigin
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(value = "/{companyName}/orders")
	public OrderEntity[] getOrders(@PathVariable("companyName") String companyName) {

		CompanyEntity c = companyRep.findByName(companyName);
		List<OrderEntity> itemList = orderService.getOrdersByCompany(c);
		return itemList.toArray(new OrderEntity[itemList.size()]);
	}
}
