package com.shapeshop;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.shapeshop.entity.ProductEntity;
import com.shapeshop.entity.ShapeEntity;
import com.shapeshop.entity.UserEntity;
import com.shapeshop.model.UserRole;
import com.shapeshop.repository.ProductRepository;
import com.shapeshop.repository.ShapeRepository;
import com.shapeshop.repository.UserRepository;
import com.shapeshop.util.PasswordUtils;

@SpringBootApplication
public class App {

	
	@Autowired
	private PasswordUtils passwordValidationService;

	
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
	public CommandLineRunner loadUsers(UserRepository repository) {
		return (args) -> {
			
			System.out.println("creating some users");
			String passs = passwordValidationService.encryptPassword("foo");
			
			System.out.println("-->>> ");
			System.out.println("-->>> create some users !!!!!!!!!!!!!");
			System.out.println("-->>> passs " + passs);
			
			repository.save(new UserEntity(UserRole.ROLE_ADMIN, "admin", passs));
			repository.save(new UserEntity(UserRole.ROLE_USER, "user", passs));
			repository.save(new UserEntity(UserRole.ROLE_USER, "foo", passs));
		};
	}
		

	@Bean
	public CommandLineRunner loadShapes(ShapeRepository repository) {
		return (args) -> {

			System.out.println(">>> ");
			System.out.println(">>> create some shapes !!!!!!!!!!!!!");
			System.out.println(">>> ");

			// save a few shapes
			repository.save(new ShapeEntity("triangle", 3));
			repository.save(new ShapeEntity("square", 4));
			repository.save(new ShapeEntity("rhombus", 4));
			repository.save(new ShapeEntity("hexagon", 6));
			repository.save(new ShapeEntity("octagon", 8));
			repository.save(new ShapeEntity("circle", 1));

			// fetch an individual customer by ID
			ShapeEntity sh1 = repository.findById(2L);
			System.out.println(">>> fetch by id " + sh1.toString());

			// fetch customers by last name
			repository.findBySides(7).forEach(sh -> {
				System.out.println(">>> fetch by sides " + sh.toString());
			});
		};
	}

	
	
	@Bean
	public CommandLineRunner loadProducts(ProductRepository repository) {
		return (args) -> {

			System.out.println(">>> ");
			System.out.println(">>> create some products !!!!!!!!!!!!!");
			System.out.println(">>> ");

			
			
			
			
//			"id": 7,
//			"name": "Minestone - italienische Gemüsesuppe mit Basilikumpesto",
//			"price": 4.50,
//			"type": "main",
//			"imageFilename": "pizza.png",
			
			// save a few shapes
			repository.save(new ProductEntity("Minestone - italienische Gemüsesuppe mit Basilikumpesto", 
					new BigDecimal(4.50),
					"main",
					"pizza.png"
					));
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
			repository.save(new ProductEntity("Shiraz", new BigDecimal(4.50),"drinks", "pizza.png"));

			

			// fetch an individual customer by ID
//			ProductEntity sh1 = repository.findById(2L);
//			System.out.println(">>> fetch by id " + sh1.toString());

//			// fetch customers by last name
//			repository.findBySides(7).forEach(sh -> {
//				System.out.println(">>> fetch by sides " + sh.toString());
//			});
		};
	}
}