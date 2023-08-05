package com.shapeshop.config.mockdata;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import com.shapeshop.ShapeShopException;
import com.shapeshop.entity.*;
import com.shapeshop.repository.*;
import com.shapeshop.service.ProductService;
import org.springframework.data.repository.CrudRepository;

public class AnniesArtSupplies {

	public static void createCategories(CategoryRepository repository, CompanyRepository cRes) {
		System.out.println("-->>> create some cats  ! ");

		CompanyEntity ce = cRes.findByName("anniesart");

		// save a few products
		repository.save(new CategoryEntity("paints" , ce));
		repository.save(new CategoryEntity("draw" , ce));
	}

	public static void createProducts(ProductRepository repository, CompanyRepository cRes, CategoryRepository catRes, ProductService pSer) throws ShapeShopException {
		System.out.println("-->>> create some products  ! ");

		CompanyEntity ce = cRes.findByName("anniesart");
		// save a few products
		pSer.createProduct(new ProductEntity("brush", new BigDecimal(6.60), "na.png", "a brush duh", null), "anniesart", "paints");
		pSer.createProduct(new ProductEntity("paint", new BigDecimal(6.66), "na.png", "a paint duh", null), "anniesart", "paints");
		pSer.createProduct(new ProductEntity("canvas", new BigDecimal(7.60), "na.png", "a canvas duh", null), "anniesart", "paints");

		pSer.createProduct(new ProductEntity("pencil", new BigDecimal(9.60), "na.png", "a pencil duh", null), "anniesart", "draw");
		pSer.createProduct(new ProductEntity("charcoal", new BigDecimal(16.60), "na.png", "a charoal duh", null), "anniesart", "draw");



	}

	public static void createOrders(OrderRepository oRep, CompanyRepository cRes, ProductRepository pRes,
									CreditCardRepository ccRes, AddressRepository aRes, CrudRepository<OrderItemEntity, Long> oiRep) {

		System.out.println("-->>> create some orders ");

		CompanyEntity company = cRes.findByName("anniesart");

		ArrayList<ProductEntity> al = (ArrayList<ProductEntity>) pRes.findByCompany(company);
		ArrayList<CreditCardEntity> paymentData = (ArrayList<CreditCardEntity>) ccRes.findAll();
		ArrayList<AddressEntity> contactData = (ArrayList<AddressEntity>) aRes.findAll();

//		AddressEntity address_bob = contactData.get(0);
		AddressEntity address_jane = contactData.get(1);

		ProductEntity product_brush= al.get(1);
		ProductEntity product_paint = al.get(2);

		OrderItemEntity orderItem1 = null;
		OrderItemEntity orderItem2 = null;

		{
			OrderEntity o1 = new OrderEntity(new Date(1639619535992l), PaymentType.CASH, DeliveryType.PICKUP, address_jane,
					null, company);

			orderItem1 = new OrderItemEntity(product_brush, 10);
			ArrayList<OrderItemEntity> oies = new ArrayList<>();
			oies.add(orderItem1);

			o1.setOrderItems(oies);

			oiRep.save(orderItem1);
			oRep.save(o1);
		}
	}
}
