package com.shapeshop;

import com.shapeshop.entity.AddressEntity;
import com.shapeshop.entity.CompanyEntity;
import com.shapeshop.entity.CreditCardEntity;
import com.shapeshop.entity.UserEntity;
import com.shapeshop.mockdata.Alpenhof;
import com.shapeshop.mockdata.Higgins;
import com.shapeshop.model.UserRole;
import com.shapeshop.repository.*;
import com.shapeshop.security.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * The test config creates data for the in memory database, and is only run in test context.
 */
@TestConfiguration
public class TestConfig {

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


	@Bean
	public CommandLineRunner loadCompanies(CompanyRepository repository) {
		return (args) -> {

			System.out.println("-->>> create some companies ! ");

			repository.save(new CompanyEntity("alpenhof"));
			repository.save(new CompanyEntity("higgins"));
		};
	}

	@Bean
	public CommandLineRunner loadAddresses(AddressRepository repository) {
		return (args) -> {
			AddressEntity a = new AddressEntity("Jar Jar Binks", "Bluw Lane Hwy 12", "41412", "+(09)928423444", "jj@gmail.com");
			repository.save(a);
			AddressEntity a2 = new AddressEntity("Luke Skywalker", "1 Baker st", "62344", "+(09)34534444", "ls@gmail.com");
			repository.save(a2);
			AddressEntity a3 = new AddressEntity("Darth Vader", null, null, "+(09)42344333", null);
			repository.save(a3);
		};
	}

	@Bean
	public CommandLineRunner loadCC(CreditCardRepository repository) {
		return (args) -> {
			CreditCardEntity cc = new CreditCardEntity("xxx-xxx-xxxx-6345", "22/22", "JJ Binks", "VISA");
			repository.save(cc);
			CreditCardEntity cc2 = new CreditCardEntity("xxx-xxx-xxxx-6523", "12/24", "P Leah", "MASTERCARD");
			repository.save(cc2);
		};
	}

	@Bean
	public CommandLineRunner loadProducts2(ProductRepository repository) {
		return (args) -> {
			Higgins.createProducts(repository, cRes);
		};
	}

	@Bean
	public CommandLineRunner loadProducts(ProductRepository repository) {
		return (args) -> {
			Alpenhof.createProducts(repository, cRes);
		};
	}

	@Bean
	public CommandLineRunner loadOrders(OrderRepository oRep) {
		return (args) -> {
			Alpenhof.createOrders(oRep, cRes, pRes, ccRes, aRes, oiRep);
		};
	}

	@Bean
	public CommandLineRunner loadOrders2(OrderRepository oRep) {
		return (args) -> {
			Higgins.createOrders(oRep, cRes, pRes, ccRes, aRes, oiRep);
		};
	}

	@Bean
	public CommandLineRunner loadUsers(UserRepository repository) {
		return (args) -> {

			String passs = passwordValidationService.encryptPassword("foo");

			System.out.println("-->>> create some users ! password = " + passs);

//			TODO users should be bound to company
			repository.save(new UserEntity(UserRole.ROLE_ADMIN, "admin", passs));
			repository.save(new UserEntity(UserRole.ROLE_USER, "user", passs));
			repository.save(new UserEntity(UserRole.ROLE_USER, "foo", passs));
		};
	}
}
