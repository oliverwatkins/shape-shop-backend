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
import com.shapeshop.entity.PaymentType;
import com.shapeshop.entity.ProductEntity;
import com.shapeshop.repository.AddressRepository;
import com.shapeshop.repository.CompanyRepository;
import com.shapeshop.repository.CreditCardRepository;
import com.shapeshop.repository.OrderRepository;
import com.shapeshop.repository.ProductRepository;

public class Higgins {

	public static void createProducts(ProductRepository repository, CompanyRepository cRes) {
		System.out.println("-->>> create some products (higgins) ! ");

		CompanyEntity ce = cRes.findByName("higgins");

		repository.save(new ProductEntity("Limit Session IPA", new BigDecimal(7.50), "main", "beer.png", ce));
		repository.save(new ProductEntity("Idaho NE Pale Ale", new BigDecimal(4.50), "main", "beer.png", ce));
		repository.save(new ProductEntity("Eclipse Black IPA", new BigDecimal(3.50), "main", "beer.png", ce));

		repository.save(new ProductEntity("NEW Release! Outer Limit Session IPA", new BigDecimal(1.50), "main",
				"beer.png", ce));
		repository.save(new ProductEntity("Trailblazer Table Beer", new BigDecimal(4.50), "main", "beer.png", ce));
		repository.save(
				new ProductEntity("Escape English Special Bitter", new BigDecimal(7.50), "main", "beer.png", ce));

		repository.save(new ProductEntity("Peak Seeker IPA", new BigDecimal(8.50), "main", "beer.png", ce));
		repository.save(new ProductEntity("Pioneer Cream Ale", new BigDecimal(4.50), "main", "beer.png", ce));
		repository.save(new ProductEntity("Pumpkin Ale", new BigDecimal(4.50), "main", "beer.png", ce));
		
		
		repository.save(new ProductEntity("2L stainless steel growlers", new BigDecimal(12.50), "accessories", "growler.png", ce));
		repository.save(new ProductEntity("T-Shirt", new BigDecimal(12.50), "accessories", "tshirt.jpg", ce));
		repository.save(new ProductEntity("Beer Mats", new BigDecimal(12.50), "accessories", "beermat.jpg", ce));
	}
	
	
	public static void createOrders(OrderRepository oRep, CompanyRepository cRes, ProductRepository pRes,
			CreditCardRepository ccRes, AddressRepository aRes, CrudRepository<OrderItemEntity, Long> oiRep) {
		
		System.out.println("-->>> create some orders (higgins) !!! ");

		CompanyEntity ce = cRes.findByName("higgins");

		ArrayList<ProductEntity> al = (ArrayList<ProductEntity>) pRes.findByCompany(ce);
		ArrayList<CreditCardEntity> ccE = (ArrayList<CreditCardEntity>) ccRes.findAll();
		ArrayList<AddressEntity> adds = (ArrayList<AddressEntity>) aRes.findAll();

		ProductEntity p1 = al.get(0);
		ProductEntity p2 = al.get(1);

		OrderEntity o = new OrderEntity(new Date(), PaymentType.CARD, DeliveryType.DELIVERY, adds.get(0),
				ccE.get(0), ce);

		OrderItemEntity oi1 = new OrderItemEntity(p1, 99);
		OrderItemEntity oi2 = new OrderItemEntity(p2, 9);

		ArrayList<OrderItemEntity> oies = new ArrayList<OrderItemEntity>();

		oies.add(oi1);
		oies.add(oi2);

		o.setOrderItems(oies);

		oiRep.save(oi1);
		oiRep.save(oi2);

		oRep.save(o);
	}
}
