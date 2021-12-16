package com.shapeshop;

import com.shapeshop.entity.AddressEntity;
import com.shapeshop.entity.CompanyEntity;
import com.shapeshop.entity.CreditCardEntity;
import com.shapeshop.entity.UserEntity;
import com.shapeshop.mockdata.Carlscafe;
import com.shapeshop.mockdata.AnniesArtSupplies;
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

			repository.save(new CompanyEntity("carlscafe"));
			repository.save(new CompanyEntity("higgins"));
		};
	}

	@Bean
	public CommandLineRunner loadAddresses(AddressRepository repository) {
		return (args) -> {
			AddressEntity a = new AddressEntity("Bob", "Bluw Lane Hwy 12", "41412", "+(09)928423444", "jj@gmail.com");
			repository.save(a);
			AddressEntity a2 = new AddressEntity("Jane", "1 Baker st", "62344", "+(09)34534444", "ls@gmail.com");
			repository.save(a2);
		};
	}

	@Bean
	public CommandLineRunner loadCC(CreditCardRepository repository) {
		return (args) -> {
			CreditCardEntity cc = new CreditCardEntity("xxxx-xxxx-xxxx-1234", "22/22", "Bob", "VISA");
			repository.save(cc);
			CreditCardEntity cc2 = new CreditCardEntity("xxx-xxx-xxxx-6789", "12/24", "Jane", "MASTERCARD");
			repository.save(cc2);
		};
	}

	@Bean
	public CommandLineRunner loadProducts2(ProductRepository repository) {
		return (args) -> {
			AnniesArtSupplies.createProducts(repository, cRes);
		};
	}

	@Bean
	public CommandLineRunner loadProducts(ProductRepository repository) {
		return (args) -> {
			Carlscafe.createProducts(repository, cRes);
		};
	}

	@Bean
	public CommandLineRunner loadOrders(OrderRepository oRep) {
		return (args) -> {
			Carlscafe.createOrders(oRep, cRes, pRes, ccRes, aRes, oiRep);
		};
	}

	@Bean
	public CommandLineRunner loadOrders2(OrderRepository oRep) {
		return (args) -> {
			AnniesArtSupplies.createOrders(oRep, cRes, pRes, ccRes, aRes, oiRep);
		};
	}

	@Bean
	public CommandLineRunner loadUsers(UserRepository repository) {
		return (args) -> {

			String fpasss = passwordValidationService.encryptPassword("foo");
			String apasss = passwordValidationService.encryptPassword("admin");
			String upasss = passwordValidationService.encryptPassword("user");

			System.out.println("-->>> create some users ! admin password = " + apasss);
			System.out.println("-->>> create some users ! user password = " + upasss);
			System.out.println("-->>> create some users ! foo password = " + fpasss);

//			TODO users should be bound to company
			repository.save(new UserEntity(UserRole.ROLE_ADMIN, "admin", apasss));
			repository.save(new UserEntity(UserRole.ROLE_USER, "user", upasss));
			repository.save(new UserEntity(UserRole.ROLE_USER, "foo", fpasss));
		};
	}
}
