package com.shapeshop.config.mockdata;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.shapeshop.ShapeShopException;
import com.shapeshop.entity.*;
import com.shapeshop.repository.*;
import com.shapeshop.service.CategoryService;
import com.shapeshop.service.ProductService;
import org.springframework.data.repository.CrudRepository;

public class Carlscafe {


	public static void createCategories(CategoryRepository repository, CompanyRepository cRes, CategoryService catSer) throws ShapeShopException {
		System.out.println("-->>> create some cats  ! ");

		catSer.createCategory(new CategoryEntity("main"), "carlscafe");
		catSer.createCategory(new CategoryEntity("drinks"), "carlscafe");
		catSer.createCategory(new CategoryEntity("biskits"), "carlscafe");
		catSer.createCategory(new CategoryEntity("teas"), "carlscafe");
	}

	
	public static void createProducts(ProductRepository repository, CompanyRepository cRes, CategoryRepository catRes, ProductService pSer) throws ShapeShopException {

		System.out.println("-->>> create some products  ! ");
		pSer.createProduct(new ProductEntity("hamburger", new BigDecimal(1.50),  "na.png", "a hambirger"), "carlscafe",  "main");
		pSer.createProduct(new ProductEntity("hotdog", new BigDecimal(2.50),  "na.png", "a hotdog"), "carlscafe",  "main");
		pSer.createProduct(new ProductEntity("donut", new BigDecimal(3.50),  "na.png", "a dougnut"), "carlscafe",  "main");
		pSer.createProduct(new ProductEntity("coke", new BigDecimal(4.50),  "na.png", "a koke"), "carlscafe",  "drinks");
		pSer.createProduct(new ProductEntity("water", new BigDecimal(6.50),  "na.png", "a water duh"), "carlscafe",  "drinks");
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
	}

}
