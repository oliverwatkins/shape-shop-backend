package com.shapeshop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

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
import com.shapeshop.repository.OrderItemRepository;
import com.shapeshop.repository.OrderRepository;
import com.shapeshop.repository.ProductRepository;

public class Alpenhof {

	
	public static void createProducts(ProductRepository repository, CompanyRepository cRes) {

		System.out.println("-->>> create some products (alpenhof) ! ");

		CompanyEntity ce = cRes.findByName("alpenhof");

		// save a few products
		repository.save(new ProductEntity("Minestone - italienische Gemüsesuppe mit Basilikumpesto",
				new BigDecimal(4.50), "main", "pizza.png", ce));
		repository
				.save(new ProductEntity("Gegrillte Calamari gefüllt mit Zucchini und Paprika auf Aurberginen-Püree",
						new BigDecimal(7.90), "main", "pizza.png", ce));
		repository.save(new ProductEntity(
				"Zucchiniröllchen gefüllt mit Ziegenkäse und Honig auf Rucolasalat mit Roten Beten und gerösteten Mandeln",
				new BigDecimal(7.90), "main", "pizza.png", ce));
		repository.save(new ProductEntity("Lachs-Spinat-Lasagne", new BigDecimal(10.90), "main", "pizza.png", ce));
		repository.save(new ProductEntity("Lasagna Classica al Forno mit Hackfleisch", new BigDecimal(9.90), "main",
				"pizza.png", ce));
		repository.save(new ProductEntity("Ravioli gefüllt mit Bärlauch und Ricotta in Zitronenbutter mit Spargel",
				new BigDecimal(11.90), "main", "pizza.png", ce));
		repository.save(new ProductEntity("Hausgemachte Rosmarin-Gnocchi mit Hirschragout", new BigDecimal(11.90),
				"main", "pizza.png", ce));
		repository.save(new ProductEntity(
				"Fritto misto di Verdura – frittierter Blumenkohl, Zucchini, Champignons, Paprika, Aubergine und Artischockenherz mit Knoblauchmayonnaise und Kräuterkartoffeln",
				new BigDecimal(12.90), "main", "pizza.png", ce));
		repository.save(new ProductEntity("Pizza mit grünem und Weißem Spargel und Kirschtomaten",
				new BigDecimal(10.90), "main", "pizza.png", ce));
		repository.save(new ProductEntity("Pizza mit Mortadella, Burrata und Trüffelcreme", new BigDecimal(10.90),
				"main", "pizza.png", ce));
		repository.save(new ProductEntity("Pizza mit Kirschtomaten, Burrata und Basilikum-Pesto",
				new BigDecimal(10.90), "main", "pizza.png", ce));
		repository.save(new ProductEntity(
				"Saltimbocca alla Romana – Kalbslendenmedaillons mit Salbei und Parmaschinken in Weißweinsauce, dazu Kartoffel-Gemüse-Gratin",
				new BigDecimal(13.90), "main", "pizza.png", ce));
		repository.save(new ProductEntity(
				"Gegrillte Spieße mit Salsiccia, Hähnchenbrust, Rinderlende und Zwiebeln, dazu hausgemachte Barbecuesauce und Kräuterkartoffeln",
				new BigDecimal(13.90), "main", "pizza.png", ce));
		repository.save(new ProductEntity(
				"Fritto Misto di Pesce -  frittierte Fische und Meeresfrüchte mit Knoblauch-Mayonnaise und Kräuterkartoffeln",
				new BigDecimal(13.90), "main", "pizza.png", ce));
		repository.save(new ProductEntity("Mango-Panna Cotta mit Erdbeersalat", new BigDecimal(4.50), "main",
				"pizza.png", ce));
		repository.save(new ProductEntity("Chardonay", new BigDecimal(4.50), "drinks", "pizza.png", ce));
		repository.save(new ProductEntity("Shiraz", new BigDecimal(4.50), "drinks", "pizza.png", ce));
	}

	public static void createOrders(OrderRepository oRep, CompanyRepository cRes, ProductRepository pRes,
			CreditCardRepository ccRes, AddressRepository aRes, OrderItemRepository oiRep) {
		
		System.out.println("-->>> create some orders (alpenhof) !!! ");

		CompanyEntity company = cRes.findByName("alpenhof");

		ArrayList<ProductEntity> al = (ArrayList<ProductEntity>) pRes.findByCompany(company);
		ArrayList<CreditCardEntity> paymentData = (ArrayList<CreditCardEntity>) ccRes.findAll();
		ArrayList<AddressEntity> contactData = (ArrayList<AddressEntity>) aRes.findAll();

		ProductEntity p1 = al.get(0);
		ProductEntity p2 = al.get(1);
		ProductEntity p3 = al.get(2);
		ProductEntity p4 = al.get(3);
		
		{
			OrderEntity o1 = new OrderEntity(new Date(), PaymentType.CARD, DeliveryType.DELIVERY, contactData.get(0),
					paymentData.get(0), company);

			OrderItemEntity oi1 = new OrderItemEntity(p2, 2);
			OrderItemEntity oi2 = new OrderItemEntity(p3, 1);

			ArrayList<OrderItemEntity> oies = new ArrayList<OrderItemEntity>();

			oies.add(oi1);
			oies.add(oi2);

			o1.setOrderItems(oies);

			oiRep.save(oi1);
			oiRep.save(oi2);

			oRep.save(o1);

		}

		{
			OrderEntity order = new OrderEntity(new Date(), PaymentType.CASH, DeliveryType.DELIVERY, contactData.get(1),
					null, company);

			OrderItemEntity oi1 = new OrderItemEntity(p1, 3);
			OrderItemEntity oi2 = new OrderItemEntity(p2, 2);

			ArrayList<OrderItemEntity> orderItems = new ArrayList<OrderItemEntity>();

			orderItems.add(oi1);
			orderItems.add(oi2);

			order.setOrderItems(orderItems);

			oiRep.save(oi1);
			oiRep.save(oi2);

			oRep.save(order);
		}
		
		{
			OrderEntity order = new OrderEntity(new Date(), PaymentType.CARD, DeliveryType.PICKUP, contactData.get(2),
					paymentData.get(1), company);

			OrderItemEntity oi1 = new OrderItemEntity(p1, 3);
			OrderItemEntity oi2 = new OrderItemEntity(p3, 2);
			OrderItemEntity oi3 = new OrderItemEntity(p3, 2);

			ArrayList<OrderItemEntity> orderItems = new ArrayList<OrderItemEntity>();

			orderItems.add(oi1);
			orderItems.add(oi2);
			orderItems.add(oi3);

			order.setOrderItems(orderItems);

			oiRep.save(oi1);
			oiRep.save(oi2);
			oiRep.save(oi3);

			oRep.save(order);
		}
		
		{
			OrderEntity order = new OrderEntity(new Date(), PaymentType.CARD, DeliveryType.PICKUP, contactData.get(2),
					paymentData.get(1), company);
			
			order.setState(OrderState.CLOSED);

			OrderItemEntity oi1 = new OrderItemEntity(p1, 3);
			OrderItemEntity oi2 = new OrderItemEntity(p3, 2);

			ArrayList<OrderItemEntity> orderItems = new ArrayList<OrderItemEntity>();

			orderItems.add(oi1);
			orderItems.add(oi2);

			order.setOrderItems(orderItems);

			oiRep.save(oi1);
			oiRep.save(oi2);

			oRep.save(order);
		}
		
	}
}
