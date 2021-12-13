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

public class Alpenhof {

	
	public static void createProducts(ProductRepository repository, CompanyRepository cRes) {

		System.out.println("-->>> create some products (alpenhof) ! ");

		CompanyEntity ce = cRes.findByName("alpenhof");

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

		CompanyEntity company = cRes.findByName("alpenhof");

		ArrayList<ProductEntity> al = (ArrayList<ProductEntity>) pRes.findByCompany(company);
		ArrayList<CreditCardEntity> paymentData = (ArrayList<CreditCardEntity>) ccRes.findAll();
		ArrayList<AddressEntity> contactData = (ArrayList<AddressEntity>) aRes.findAll();

//		ProductEntity p1 = al.get(0);
		ProductEntity p2 = al.get(1);
		ProductEntity p3 = al.get(2);
//		ProductEntity p4 = al.get(3);
		
		{
			OrderEntity o1 = new OrderEntity(new Date(), PaymentType.CARD, DeliveryType.DELIVERY, contactData.get(0),
					paymentData.get(0), company);

			OrderItemEntity oi1 = new OrderItemEntity(p2, 2);
//			OrderItemEntity oi2 = new OrderItemEntity(p3, 1);

			ArrayList<OrderItemEntity> oies = new ArrayList<OrderItemEntity>();

			oies.add(oi1);
//			oies.add(oi2);

			o1.setOrderItems(oies);

			oiRep.save(oi1);
//			oiRep.save(oi2);

			oRep.save(o1);

		}

		{
			OrderEntity order = new OrderEntity(new Date(), PaymentType.CASH, DeliveryType.DELIVERY, contactData.get(1),
					null, company);

//			OrderItemEntity oi1 = new OrderItemEntity(p1, 3);
			OrderItemEntity oi2 = new OrderItemEntity(p2, 2);

			ArrayList<OrderItemEntity> orderItems = new ArrayList<OrderItemEntity>();

//			orderItems.add(oi1);
			orderItems.add(oi2);

			order.setOrderItems(orderItems);

//			oiRep.save(oi1);
			oiRep.save(oi2);

			oRep.save(order);
		}
		
		{
			OrderEntity order = new OrderEntity(new Date(), PaymentType.CARD, DeliveryType.PICKUP, contactData.get(2),
					paymentData.get(1), company);

//			OrderItemEntity oi1 = new OrderItemEntity(p1, 3);
			OrderItemEntity oi2 = new OrderItemEntity(p3, 2);
			OrderItemEntity oi3 = new OrderItemEntity(p3, 2);

			ArrayList<OrderItemEntity> orderItems = new ArrayList<OrderItemEntity>();

//			orderItems.add(oi1);
			orderItems.add(oi2);
			orderItems.add(oi3);

			order.setOrderItems(orderItems);

//			oiRep.save(oi1);
			oiRep.save(oi2);
			oiRep.save(oi3);

			oRep.save(order);
		}
		
		{
			OrderEntity order = new OrderEntity(new Date(), PaymentType.CARD, DeliveryType.PICKUP, contactData.get(2),
					paymentData.get(1), company);
			
			order.setState(OrderState.CLOSED);

//			OrderItemEntity oi1 = new OrderItemEntity(p1, 3);
			OrderItemEntity oi2 = new OrderItemEntity(p3, 2);

			ArrayList<OrderItemEntity> orderItems = new ArrayList<OrderItemEntity>();

//			orderItems.add(oi1);
			orderItems.add(oi2);

			order.setOrderItems(orderItems);

//			oiRep.save(oi1);
			oiRep.save(oi2);

			oRep.save(order);
		}
		
	}
}
