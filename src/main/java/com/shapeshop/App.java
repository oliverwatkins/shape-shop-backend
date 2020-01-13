package com.shapeshop;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.shapeshop.entity.Shape;
import com.shapeshop.entity.User;
import com.shapeshop.model.UserRole;
import com.shapeshop.repository.ShapeRepository;
import com.shapeshop.repository.UserRepository;
import com.shapeshop.service.PasswordValidationService;

@SpringBootApplication
public class App {

	
	@Autowired
	private PasswordValidationService passwordValidationService;

	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
//            System.out.println("Let's inspect the beans provided by Spring Boot:");
//            String[] beanNames = ctx.getBeanDefinitionNames();
//            Arrays.sort(beanNames);
//            for (String beanName : beanNames) {
//                System.out.println(beanName);
//            }
		};
	}
	
	@Bean
	public CommandLineRunner loadUsers(UserRepository repository) {
		return (args) -> {
			
			String passs = passwordValidationService.encryptPassword("pass");
			
			System.out.println(">>> ");
			System.out.println(">>> create some users !!!!!!!!!!!!!");
			System.out.println(">>> passs " + passs);
			
			repository.save(new User(UserRole.ADMIN, "admin", passs, "custid", "blah", Locale.GERMANY));
			repository.save(new User(UserRole.USER, "user", passs, "custid", "blah", Locale.GERMANY));
		};
	}

		

	@Bean
	public CommandLineRunner loadShapes(ShapeRepository repository) {
		return (args) -> {

			System.out.println(">>> ");
			System.out.println(">>> create some shapes !!!!!!!!!!!!!");
			System.out.println(">>> ");

			// save a few shapes
			repository.save(new Shape("triangle", 3));
			repository.save(new Shape("square", 4));
			repository.save(new Shape("rhombus", 4));
			repository.save(new Shape("hexagon", 6));
			repository.save(new Shape("octagon", 8));
			repository.save(new Shape("circle", 1));

			// fetch an individual customer by ID
			Shape sh1 = repository.findById(2L);
			System.out.println(">>> fetch by id " + sh1.toString());

			// fetch customers by last name
			repository.findBySides(7).forEach(sh -> {
				System.out.println(">>> fetch by sides " + sh.toString());
			});
		};
	}

}