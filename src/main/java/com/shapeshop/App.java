package com.shapeshop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.shapeshop.entity.AddressEntity;
import com.shapeshop.entity.CompanyEntity;
import com.shapeshop.entity.CreditCardEntity;
import com.shapeshop.entity.DeliveryType;
import com.shapeshop.entity.OrderEntity;
import com.shapeshop.entity.OrderItemEntity;
import com.shapeshop.entity.PaymentType;
import com.shapeshop.entity.ProductEntity;
import com.shapeshop.entity.UserEntity;
import com.shapeshop.model.UserRole;
import com.shapeshop.repository.AddressRepository;
import com.shapeshop.repository.CompanyRepository;
import com.shapeshop.repository.CreditCardRepository;
import com.shapeshop.repository.OrderItemRepository;
import com.shapeshop.repository.OrderRepository;
import com.shapeshop.repository.ProductRepository;
import com.shapeshop.repository.UserRepository;
import com.shapeshop.util.PasswordUtils;

@SpringBootApplication
public class App {

	
	@Autowired
	private PasswordUtils passwordValidationService;
	
	@Autowired
	ProductRepository pRes;

	@Autowired
	OrderItemRepository oiRep;

	@Autowired
	CompanyRepository cRes;

	@Autowired
	CreditCardRepository ccRes;
	
	@Autowired
	AddressRepository aRes;
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("<<<<<>>>>> SHAPE SHOP <<<<<>>>>> ");
		};
	}

	@Bean
	public CommandLineRunner loadCompanies(CompanyRepository repository) {
		return (args) -> {

			System.out.println("-->>> create some companies ! ");
			
			// save a few products
			repository.save(new CompanyEntity("alpenhof"));
			repository.save(new CompanyEntity("higgins"));
		};
	}
	
	
	@Bean
	public CommandLineRunner loadProducts2(ProductRepository repository) {
		return (args) -> {

			System.out.println("-->>> create some products ! ");
			
			CompanyEntity ce = cRes.findByName("higgins");
			
			repository.save(new ProductEntity("Limit Session IPA", new BigDecimal(7.50), "main", "beer.png", ce));
			repository.save(new ProductEntity("Idaho NE Pale Ale", new BigDecimal(4.50), "main", "beer.png", ce));
			repository.save(new ProductEntity("Eclipse Black IPA", new BigDecimal(3.50), "main", "beer.png", ce));
			
			repository.save(new ProductEntity("NEW Release! Outer Limit Session IPA", new BigDecimal(1.50), "main", "beer.png", ce));
			repository.save(new ProductEntity("Trailblazer Table Beer", new BigDecimal(4.50), "main", "beer.png", ce));
			repository.save(new ProductEntity("Escape English Special Bitter", new BigDecimal(7.50), "main", "beer.png", ce));
			
			repository.save(new ProductEntity("Peak Seeker IPA", new BigDecimal(8.50), "main", "beer.png", ce));
			repository.save(new ProductEntity("Pioneer Cream Ale", new BigDecimal(4.50), "main", "beer.png", ce));
			repository.save(new ProductEntity("Pumpkin Ale", new BigDecimal(4.50), "main", "beer.png", ce));
			
		};
	}
	

	
	@Bean
	public CommandLineRunner loadProducts(ProductRepository repository) {
		return (args) -> {

			System.out.println("-->>> create some products ! ");
			
			CompanyEntity ce = cRes.findByName("alpenhof");
			
			// save a few products
			repository.save(new ProductEntity("Minestone - italienische Gemüsesuppe mit Basilikumpesto", new BigDecimal(4.50), "main", "pizza.png", ce));
			repository.save(new ProductEntity("Gegrillte Calamari gefüllt mit Zucchini und Paprika auf Aurberginen-Püree", new BigDecimal(7.90),"main", "pizza.png", ce));
			repository.save(new ProductEntity("Zucchiniröllchen gefüllt mit Ziegenkäse und Honig auf Rucolasalat mit Roten Beten und gerösteten Mandeln", new BigDecimal(7.90),"main", "pizza.png", ce));
			repository.save(new ProductEntity("Lachs-Spinat-Lasagne", new BigDecimal(10.90),"main", "pizza.png", ce));
			repository.save(new ProductEntity("Lasagna Classica al Forno mit Hackfleisch", new BigDecimal(9.90),"main", "pizza.png", ce));
			repository.save(new ProductEntity("Ravioli gefüllt mit Bärlauch und Ricotta in Zitronenbutter mit Spargel", new BigDecimal(11.90),"main", "pizza.png", ce));
			repository.save(new ProductEntity("Hausgemachte Rosmarin-Gnocchi mit Hirschragout", new BigDecimal(11.90),"main", "pizza.png", ce));
			repository.save(new ProductEntity("Fritto misto di Verdura – frittierter Blumenkohl, Zucchini, Champignons, Paprika, Aubergine und Artischockenherz mit Knoblauchmayonnaise und Kräuterkartoffeln", new BigDecimal(12.90),"main", "pizza.png", ce));
			repository.save(new ProductEntity("Pizza mit grünem und Weißem Spargel und Kirschtomaten", new BigDecimal(10.90),"main", "pizza.png", ce));
			repository.save(new ProductEntity("Pizza mit Mortadella, Burrata und Trüffelcreme", new BigDecimal(10.90),"main", "pizza.png", ce));
			repository.save(new ProductEntity("Pizza mit Kirschtomaten, Burrata und Basilikum-Pesto", new BigDecimal(10.90),"main", "pizza.png", ce));
			repository.save(new ProductEntity("Saltimbocca alla Romana – Kalbslendenmedaillons mit Salbei und Parmaschinken in Weißweinsauce, dazu Kartoffel-Gemüse-Gratin", new BigDecimal(13.90),"main", "pizza.png", ce));
			repository.save(new ProductEntity("Gegrillte Spieße mit Salsiccia, Hähnchenbrust, Rinderlende und Zwiebeln, dazu hausgemachte Barbecuesauce und Kräuterkartoffeln", new BigDecimal(13.90),"main", "pizza.png", ce));
			repository.save(new ProductEntity("Fritto Misto di Pesce -  frittierte Fische und Meeresfrüchte mit Knoblauch-Mayonnaise und Kräuterkartoffeln", new BigDecimal(13.90),"main", "pizza.png", ce));
			repository.save(new ProductEntity("Mango-Panna Cotta mit Erdbeersalat", new BigDecimal(4.50),"main", "pizza.png", ce));
			repository.save(new ProductEntity("Chardonay", new BigDecimal(4.50),"drinks", "pizza.png", ce));
			ProductEntity pe = repository.save(new ProductEntity("Shiraz", new BigDecimal(4.50),"drinks", "pizza.png", ce));
			System.out.println("got pe " + pe);
		};
	}
	
	@Bean
	public CommandLineRunner loadUsers(UserRepository repository) {
		return (args) -> {
			
			String passs = passwordValidationService.encryptPassword("foo");
			
			System.out.println("-->>> create some users ! ");
			
			repository.save(new UserEntity(UserRole.ROLE_ADMIN, "admin", passs));
			repository.save(new UserEntity(UserRole.ROLE_USER, "user", passs));
			repository.save(new UserEntity(UserRole.ROLE_USER, "foo", passs));
		};
	}
	
	
	@Bean
	public CommandLineRunner loadAddresses(AddressRepository repository) {
		return (args) -> {
			AddressEntity a = new AddressEntity("Jar Jar Binks", "Bluw Lane Hwy 12", "41412", "+(09)928423444");
			repository.save(a);
		};
	}
	
	@Bean
	public CommandLineRunner loadCC(CreditCardRepository repository) {
		return (args) -> {
			CreditCardEntity cc = new CreditCardEntity("23412341234", "22/22", "JJ Binks", "VISA");
			repository.save(cc);
		};
	}
	
	@Bean
	public CommandLineRunner loadOrders(OrderRepository oRep) {
		return (args) -> {
			
			System.out.println("-->>> create some orders (alpenhof) !!! ");
			
			CompanyEntity ce = cRes.findByName("alpenhof");
			
			ArrayList<ProductEntity> al = (ArrayList<ProductEntity>) pRes.findByCompany(ce);
			ArrayList<CreditCardEntity> ccE = (ArrayList<CreditCardEntity>) ccRes.findAll();
			ArrayList<AddressEntity> adds = (ArrayList<AddressEntity>) aRes.findAll();
			
			ProductEntity p1 = al.get(0);
			ProductEntity p2 = al.get(1);
			
			
			OrderEntity o1 = new OrderEntity(
					new Date(), 
					PaymentType.CARD, 
					DeliveryType.DELIVERY, 
					adds.get(0), 
					ccE.get(0), 
					ce);
			
			oRep.save(o1);
			
			OrderEntity o2 = new OrderEntity(
					new Date(), 
					PaymentType.CARD, 
					DeliveryType.DELIVERY, 
					adds.get(0), 
					ccE.get(0), 
					ce);

			
			OrderItemEntity oi1 = new OrderItemEntity(p1, 12);
			OrderItemEntity oi2 = new OrderItemEntity(p2, 12);
			
			ArrayList<OrderItemEntity> oies = new ArrayList<OrderItemEntity>();

			oies.add(oi1);
			oies.add(oi2);
			
			o2.setOrderItems(oies);
			
			oiRep.save(oi1);
			oiRep.save(oi2);
			
			oRep.save(o2);
			
			
//			List l = (List)oRep.findAll();
//			
//			System.out.println("l " + l );
			
			



		};
	}
	
	
	@Bean
	public CommandLineRunner loadOrders2(OrderRepository repository) {
		return (args) -> {
//			
//			System.out.println("-->>> create some orders !!! ");
//			
//			CompanyEntity ce = cRes.findByName("higgins");
//			
//			ArrayList<ProductEntity> al = (ArrayList<ProductEntity>) pRes.findByCompany(ce);
//			ArrayList<CreditCardEntity> ccE = (ArrayList<CreditCardEntity>) ccRes.findAll();
//			ArrayList<AddressEntity> adds = (ArrayList<AddressEntity>) aRes.findAll();
//			
//			OrderEntity o = new OrderEntity(
//					new Date(), 
//					PaymentType.CARD, 
//					DeliveryType.DELIVERY, 
//					adds.get(0), 
//					ccE.get(0), 
//					ce);
//			
//			OrderItemEntity oi = new OrderItemEntity(al.get(0), o, "");
//			
//			repository.save();
//			repository.save(new OrderEntity("Luke Skywalker2 ", "845545664",new Date(), PaymentType.CASH, DeliveryType.PICKUP, "55 Higginsstr", ce));
		};
	}
}