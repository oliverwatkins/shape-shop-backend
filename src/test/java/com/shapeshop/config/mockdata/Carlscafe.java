package com.shapeshop.config.mockdata;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.shapeshop.ShapeShopException;
import com.shapeshop.entity.*;
import com.shapeshop.repository.*;
import com.shapeshop.service.ProductService;
import org.springframework.data.repository.CrudRepository;

public class Carlscafe {


	public static void createCategories(CategoryRepository repository, CompanyRepository cRes) {
		System.out.println("-->>> create some cats  ! ");

		CompanyEntity ce = cRes.findByName("carlscafe");

		// save a few products

//		repository.save(new CategoryEntity("paints" , ce));
//		repository.save(new CategoryEntity("draw" , ce));
		repository.save(new CategoryEntity("main" , ce));
		repository.save(new CategoryEntity("drinks" , ce));
		repository.save(new CategoryEntity("biskits" , ce));
		repository.save(new CategoryEntity("teas" , ce));
	}

	
	public static void createProducts(ProductRepository repository, CompanyRepository cRes, CategoryRepository catRes, ProductService pSer) throws ShapeShopException {

		System.out.println("-->>> create some products  ! ");

		CompanyEntity ce = cRes.findByName("carlscafe");

		List<CategoryEntity> catE = catRes.findByCompany(ce);


		pSer.createProduct(new ProductEntity("hamburger", new BigDecimal(1.50),  "na.png", "a hambirger"), "carlscafe",  "main");
		pSer.createProduct(new ProductEntity("hotdog", new BigDecimal(2.50),  "na.png", "a hotdog"), "carlscafe",  "main");
		pSer.createProduct(new ProductEntity("donut", new BigDecimal(3.50),  "na.png", "a dougnut"), "carlscafe",  "main");

		pSer.createProduct(new ProductEntity("coke", new BigDecimal(4.50),  "na.png", "a koke"), "carlscafe",  "drinks");
		pSer.createProduct(new ProductEntity("water", new BigDecimal(6.50),  "na.png", "a water duh"), "carlscafe",  "drinks");
		// save a few products
//		repository.save(new ProductEntity("hamburger", new BigDecimal(1.50), "main", "na.png", "a hambirger"), "",  "");
//		repository.save(new ProductEntity("hotdog", new BigDecimal(7.90), "main", "na.png", ce, "a hotdog", catE.get(0)));
//		repository.save(new ProductEntity("donut", new BigDecimal(7.90), "main", "na.png", ce, "a donut", catE.get(0)));
//
//		repository.save(new ProductEntity("coke", new BigDecimal(4.50), "drinks", "na.png", ce, "a coke", catE.get(0)));
//		repository.save(new ProductEntity("water", new BigDecimal(4.50), "drinks", "na.png", ce, "a water", catE.get(0)));
	}

	public static void createOrders(OrderRepository orderRepository, CompanyRepository cRes, ProductRepository pRes,
			CreditCardRepository ccRes, AddressRepository aRes, OrderItemRepository orderItemRepository) {
		
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
			//create order
			OrderEntity order = new OrderEntity(new Date(1639619535992l), PaymentType.CARD, DeliveryType.DELIVERY, address_bob,
					paymentData.get(0), company);

			//create order item
			orderItem1 = new OrderItemEntity(product_hotdog, 1);
			ArrayList<OrderItemEntity> orderItems = new ArrayList<OrderItemEntity>();
			orderItems.add(orderItem1);

			order.setOrderItems(orderItems);

			orderItemRepository.saveAll(orderItems);
			orderRepository.save(order);
		}
	}

}
