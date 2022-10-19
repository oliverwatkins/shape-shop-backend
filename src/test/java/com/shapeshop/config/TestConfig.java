package com.shapeshop.config;

import com.shapeshop.entity.*;
import com.shapeshop.config.mockdata.Carlscafe;
import com.shapeshop.config.mockdata.AnniesArtSupplies;
import com.shapeshop.model.UserRole;
import com.shapeshop.repository.*;
import com.shapeshop.security.PasswordUtils;
import com.shapeshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * The test config creates data for the in memory database, and is only run in test context.
 *
 * 2 companies: carls cafe, annies art
 *
 * 3 users: foo, damin, and user
 */
@TestConfiguration
public class TestConfig {

//	@Autowired
//	private PasswordUtils passwordValidationService;
//
//	@Autowired
//	ProductRepository pRep;
//
//	@Autowired
//	OrderItemRepository oiRep;
//
//	@Autowired
//	CompanyRepository cRep;
//
//	@Autowired
//	CreditCardRepository ccRep;
//
//	@Autowired
//	AddressRepository aRep;
//
//	@Autowired
//	ProductService pSer;
//
//	@Bean
//	public CommandLineRunner loadCompanies(CompanyRepository repository) {
//		return (args) -> {
//
//			System.out.println("-->>> create some companies ! ");
//
//			repository.save(new CompanyEntity("carlscafe"));
//			repository.save(new CompanyEntity("anniesart"));
//		};
//	}
//
//	@Bean
//	public CommandLineRunner loadAddresses(AddressRepository repository) {
//		return (args) -> {
//			AddressEntity a = new AddressEntity("Bob", "Bobby street 12", "41412", "+(09)928423444", "bob@gmail.com");
//			repository.save(a);
//			AddressEntity a2 = new AddressEntity("Jane", "1 Baker st", "62344", "+(09)34534444", "jane@gmail.com");
//			repository.save(a2);
//		};
//	}
//
//	@Bean
//	public CommandLineRunner loadCC(CreditCardRepository repository) {
//		return (args) -> {
//			CreditCardEntity cc = new CreditCardEntity("xxxx-xxxx-xxxx-1234", "22/22", "Bob", "VISA");
//			repository.save(cc);
//			CreditCardEntity cc2 = new CreditCardEntity("xxx-xxx-xxxx-6789", "12/24", "Jane", "MASTERCARD");
//			repository.save(cc2);
//		};
//	}
//
//	@Bean
//	public CommandLineRunner loadCategories_Annie(CategoryRepository repository) {
//		return (args) -> {
//			AnniesArtSupplies.createCategories(repository, cRep);
//		};
//	}
//
//
//	@Bean
//	public CommandLineRunner loadCategories_Carl(CategoryRepository repository) {
//		return (args) -> {
//			Carlscafe.createCategories(repository, cRep);
//		};
//	}
//
//	@Bean
//	public CommandLineRunner loadProducts_Carl(ProductRepository repository, CategoryRepository catrepository) {
//		return (args) -> {
//			Carlscafe.createProducts(repository, cRep, catrepository, pSer);
//		};
//	}
//
//	@Bean
//	public CommandLineRunner loadProducts_Annie(ProductRepository repository, CategoryRepository catrepository) {
//		return (args) -> {
//			AnniesArtSupplies.createProducts(repository, cRep, catrepository, pSer);
//		};
//	}
//
//	@Bean
//	public CommandLineRunner loadOrders(OrderRepository oRep) {
//		return (args) -> {
//			Carlscafe.createOrders(oRep, cRep, pRep, ccRep, aRep, oiRep);
//		};
//	}
//
//	@Bean
//	public CommandLineRunner loadOrders2(OrderRepository oRep) {
//		return (args) -> {
//			AnniesArtSupplies.createOrders(oRep, cRep, pRep, ccRep, aRep, oiRep);
//		};
//	}
//
//	@Bean
//	public CommandLineRunner loadUsers(UserRepository repository) {
//		return (args) -> {
//
//			String fpasss = passwordValidationService.encryptPassword("foo");
//			String apasss = passwordValidationService.encryptPassword("admin");
//			String upasss = passwordValidationService.encryptPassword("user");
//
//			System.out.println("-->>> create some users ! admin password = " + apasss);
//			System.out.println("-->>> create some users ! user password = " + upasss);
//			System.out.println("-->>> create some users ! foo password = " + fpasss);
//
////			TODO users should be bound to company
//			repository.save(new UserEntity(UserRole.ROLE_ADMIN, "admin", apasss));
//			repository.save(new UserEntity(UserRole.ROLE_USER, "user", upasss));
//			repository.save(new UserEntity(UserRole.ROLE_USER, "foo", fpasss));
//		};
//	}
}
