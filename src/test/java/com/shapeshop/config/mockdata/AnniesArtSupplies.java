package com.shapeshop.config.mockdata;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.shapeshop.entity.*;
import com.shapeshop.repository.*;
import org.springframework.data.repository.CrudRepository;

public class AnniesArtSupplies {


	public static void createCategories(CategoryRepository repository, CompanyRepository cRes) {
		System.out.println("-->>> create some cats  ! ");

		CompanyEntity ce = cRes.findByName("anniesart");

		// save a few products
		repository.save(new CategoryEntity("paints" , ce));
		repository.save(new CategoryEntity("draw" , ce));


	}

	public static void createProducts(ProductRepository repository, CompanyRepository cRes, CategoryRepository catRes) {
		System.out.println("-->>> create some products  ! ");

		CompanyEntity ce = cRes.findByName("anniesart");
		List<CategoryEntity> cat = catRes.findByCompany(ce);

		// save a few products
		repository.save(new ProductEntity("brush", new BigDecimal(6.60), "painting", "na.png", ce, "painting stuff", cat.get(0)));
		repository.save(new ProductEntity("paint", new BigDecimal(6.66), "painting", "na.png", ce, "painting stuff", cat.get(0)));
		repository.save(new ProductEntity("canvas", new BigDecimal(8.80), "painting", "na.png", ce, "painting stuff", cat.get(0)));

		repository.save(new ProductEntity("pencil", new BigDecimal(9.90), "drawing", "na.png", ce, "painting stuff", cat.get(0)));
		repository.save(new ProductEntity("charcoal", new BigDecimal(14.50), "drawing", "na.png", ce, "painting stuff", cat.get(0)));
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
