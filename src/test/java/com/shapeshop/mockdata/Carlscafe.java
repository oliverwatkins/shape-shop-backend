package com.shapeshop.mockdata;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.repository.CrudRepository;

import com.shapeshop.entity.AddressEntity;
import com.shapeshop.entity.CompanyEntity;
import com.shapeshop.entity.CreditCardEntity;
import com.shapeshop.entity.DeliveryType;
import com.shapeshop.entity.OrderEntity;
import com.shapeshop.entity.OrderItemEntity;
import com.shapeshop.entity.OrderState;
import com.shapeshop.entity.PaymentType;
import com.shapeshop.entity.ProductEntity;
import com.shapeshop.repository.AddressRepository;
import com.shapeshop.repository.CompanyRepository;
import com.shapeshop.repository.CreditCardRepository;
import com.shapeshop.repository.OrderRepository;
import com.shapeshop.repository.ProductRepository;

public class Carlscafe {

	
	public static void createProducts(ProductRepository repository, CompanyRepository cRes) {

		System.out.println("-->>> create some products  ! ");

		CompanyEntity ce = cRes.findByName("carlscafe");

		// save a few products
		repository.save(new ProductEntity("hamburger", new BigDecimal(1.50), "main", "na.png", ce));
		repository.save(new ProductEntity("hotdog", new BigDecimal(7.90), "main", "na.png", ce));
		repository.save(new ProductEntity("donut", new BigDecimal(7.90), "main", "na.png", ce));

		repository.save(new ProductEntity("coke", new BigDecimal(4.50), "drinks", "na.png", ce));
		repository.save(new ProductEntity("water", new BigDecimal(4.50), "drinks", "na.png", ce));
	}

	public static void createOrders(OrderRepository oRep, CompanyRepository cRes, ProductRepository pRes,
			CreditCardRepository ccRes, AddressRepository aRes, CrudRepository<OrderItemEntity, Long> oiRep) {
		
		System.out.println("-->>> create some orders ");

		CompanyEntity company = cRes.findByName("carlscafe");

		ArrayList<ProductEntity> al = (ArrayList<ProductEntity>) pRes.findByCompany(company);
		ArrayList<CreditCardEntity> paymentData = (ArrayList<CreditCardEntity>) ccRes.findAll();
		ArrayList<AddressEntity> contactData = (ArrayList<AddressEntity>) aRes.findAll();

		AddressEntity address_bob = contactData.get(0);
		AddressEntity address_jane = contactData.get(1);


		ProductEntity product_hotdog = al.get(1);
		ProductEntity product_donut = al.get(2);

		OrderItemEntity orderItem1 = null;
		OrderItemEntity orderItem2 = null;

		{
			OrderEntity o1 = new OrderEntity(new Date(1639619535992l), PaymentType.CARD, DeliveryType.DELIVERY, address_bob,
					paymentData.get(0), company);

			orderItem1 = new OrderItemEntity(product_hotdog, 1);
			ArrayList<OrderItemEntity> oies = new ArrayList<OrderItemEntity>();
			oies.add(orderItem1);

			o1.setOrderItems(oies);

			oiRep.save(orderItem1);
			oRep.save(o1);
		}

//		{
//			OrderEntity order = new OrderEntity(new Date(), PaymentType.CASH, DeliveryType.DELIVERY, address_jane,
//					null, company);
//
//			orderItem1 = new OrderItemEntity(product_donut, 1);
//			orderItem2 = new OrderItemEntity(product_hotdog, 2);
//
//			ArrayList<OrderItemEntity> orderItems = new ArrayList<OrderItemEntity>();
//
//			orderItems.add(orderItem2);
//
//			order.setOrderItems(orderItems);
//
//			oiRep.save(orderItem1);
//			oiRep.save(orderItem2);
//
//			oRep.save(order);
//		}
	}
}
