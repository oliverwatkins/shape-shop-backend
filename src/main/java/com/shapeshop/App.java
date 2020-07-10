package com.shapeshop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.shapeshop.entity.AddressEntity;
import com.shapeshop.entity.CreditCardEntity;
import com.shapeshop.entity.DeliveryType;
import com.shapeshop.entity.OrderEntity;
import com.shapeshop.entity.PaymentType;
import com.shapeshop.entity.ProductEntity;
import com.shapeshop.entity.UserEntity;
import com.shapeshop.model.UserRole;
import com.shapeshop.repository.AddressRepository;
import com.shapeshop.repository.CreditCardRepository;
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
	public CommandLineRunner loadProducts(ProductRepository repository) {
		return (args) -> {

			System.out.println("-->>> create some products ! ");
			
			// save a few products
			repository.save(new ProductEntity("Minestone - italienische Gemüsesuppe mit Basilikumpesto", new BigDecimal(4.50), "main", "pizza.png"));
			repository.save(new ProductEntity("Gegrillte Calamari gefüllt mit Zucchini und Paprika auf Aurberginen-Püree", new BigDecimal(7.90),"main", "pizza.png"));
			repository.save(new ProductEntity("Zucchiniröllchen gefüllt mit Ziegenkäse und Honig auf Rucolasalat mit Roten Beten und gerösteten Mandeln", new BigDecimal(7.90),"main", "pizza.png"));
			repository.save(new ProductEntity("Lachs-Spinat-Lasagne", new BigDecimal(10.90),"main", "pizza.png"));
			repository.save(new ProductEntity("Lasagna Classica al Forno mit Hackfleisch", new BigDecimal(9.90),"main", "pizza.png"));
			repository.save(new ProductEntity("Ravioli gefüllt mit Bärlauch und Ricotta in Zitronenbutter mit Spargel", new BigDecimal(11.90),"main", "pizza.png"));
			repository.save(new ProductEntity("Hausgemachte Rosmarin-Gnocchi mit Hirschragout", new BigDecimal(11.90),"main", "pizza.png"));
			repository.save(new ProductEntity("Fritto misto di Verdura – frittierter Blumenkohl, Zucchini, Champignons, Paprika, Aubergine und Artischockenherz mit Knoblauchmayonnaise und Kräuterkartoffeln", new BigDecimal(12.90),"main", "pizza.png"));
			repository.save(new ProductEntity("Pizza mit grünem und Weißem Spargel und Kirschtomaten", new BigDecimal(10.90),"main", "pizza.png"));
			repository.save(new ProductEntity("Pizza mit Mortadella, Burrata und Trüffelcreme", new BigDecimal(10.90),"main", "pizza.png"));
			repository.save(new ProductEntity("Pizza mit Kirschtomaten, Burrata und Basilikum-Pesto", new BigDecimal(10.90),"main", "pizza.png"));
			repository.save(new ProductEntity("Saltimbocca alla Romana – Kalbslendenmedaillons mit Salbei und Parmaschinken in Weißweinsauce, dazu Kartoffel-Gemüse-Gratin", new BigDecimal(13.90),"main", "pizza.png"));
			repository.save(new ProductEntity("Gegrillte Spieße mit Salsiccia, Hähnchenbrust, Rinderlende und Zwiebeln, dazu hausgemachte Barbecuesauce und Kräuterkartoffeln", new BigDecimal(13.90),"main", "pizza.png"));
			repository.save(new ProductEntity("Fritto Misto di Pesce -  frittierte Fische und Meeresfrüchte mit Knoblauch-Mayonnaise und Kräuterkartoffeln", new BigDecimal(13.90),"main", "pizza.png"));
			repository.save(new ProductEntity("Mango-Panna Cotta mit Erdbeersalat", new BigDecimal(4.50),"main", "pizza.png"));
			repository.save(new ProductEntity("Chardonay", new BigDecimal(4.50),"drinks", "pizza.png"));
			
			ProductEntity pe = repository.save(new ProductEntity("Shiraz", new BigDecimal(4.50),"drinks", "pizza.png"));
			
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
			AddressEntity a = new AddressEntity("Jar Jar Binks ");
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
	public CommandLineRunner loadOrders(OrderRepository repository) {
		return (args) -> {
//			AddressEntity a = new AddressEntity("Jar Jar Binks ");
//			CreditCardEntity cc = new CreditCardEntity("23412341234", "22/22", "JJ Binks", "VISA");
			
			System.out.println("-->>> create some orders ! ");
			
			ArrayList<ProductEntity> al = (ArrayList<ProductEntity>) pRes.findAll();
			
			repository.save(new OrderEntity(
					new Date(), 
					PaymentType.CARD, 
					DeliveryType.DELIVERY, 
					null, 
					null, 
					al));
			repository.save(new OrderEntity("Jar Jar Binks ", "845545664",new Date(), PaymentType.CASH, DeliveryType.PICKUP, "55 Somestr"));
		};
	}
}