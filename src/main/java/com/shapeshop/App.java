package com.shapeshop;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.shapeshop.entity.ShapeEntity;
import com.shapeshop.entity.UserEntity;
import com.shapeshop.model.UserRole;
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
			

			repository.save(new UserEntity(UserRole.ROLE_KING, "lion", passs));
			repository.save(new UserEntity(UserRole.ROLE_PAWN, "cub", passs));
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

}