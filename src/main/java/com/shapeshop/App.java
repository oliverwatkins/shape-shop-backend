package com.shapeshop;

import com.shapeshop.entity.CompanyEntity;
import com.shapeshop.entity.UserEntity;
import com.shapeshop.model.UserRole;
import com.shapeshop.repository.CompanyRepository;
import com.shapeshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

	@Autowired
	CompanyRepository cRes;

	public static void main(String[] args) {
		System.out.println("<<<<<>>>>> main <<<<<>>>>> ");

		SpringApplication.run(App.class, args);




	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("<<<<<>>>>> XXXXXXXXXXXXX   !!!!!!!!!!!!!!!!!! SHAPE SHOP !!!!!!!!!!!!!!!!!!!!!!!   XXXXXXXXXX      <<<<<>>>>> ");
		};
	}


	@Bean
	public CommandLineRunner testDBConnectionWorks(UserRepository repository) {
		return (args) -> {

			CompanyEntity ce = cRes.findByName("alpenhof");

			System.out.println("CompanyEntity ! " + ce);
		};
	}

	@Bean
	public CommandLineRunner commandLineRunner2(ApplicationContext ctx) {
		CompanyEntity ce = cRes.findByName("alpenhof");


		return args -> {
			System.out.println("<<<<<>>>>> XXXXXXXXXXXXX   !!!!!!!!!!!!!!!!!! SHAPE SHOP !!!!!!!!!!!!!!!!!!!!!!!   XXXXXXXXXX      <<<<<>>>>> ");
		};
	}
}
