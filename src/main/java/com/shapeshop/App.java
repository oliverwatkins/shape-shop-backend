package com.shapeshop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.shapeshop.entity.UserEntity;
import com.shapeshop.model.UserRole;
import com.shapeshop.repository.UserRepository;

@SpringBootApplication
public class App {

//	@Autowired
//	private PasswordUtils passwordValidationService;
//
//	@Autowired
//	ProductRepository pRes;
//
//	@Autowired
//	OrderItemRepository oiRep;
//
//	@Autowired
//	CompanyRepository cRes;
//
//	@Autowired
//	CreditCardRepository ccRes;
//
//	@Autowired
//	AddressRepository aRes;

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("<<<<<>>>>> My App <<<<<>>>>> ");
		};
	}

	@Bean
	public CommandLineRunner loadUsers(UserRepository repository) {
		return (args) -> {
			repository.save(new UserEntity(UserRole.ROLE_ADMIN, "foo", "bar"));
		};
	}




}