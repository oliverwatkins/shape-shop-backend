package com.shapeshop;

import com.shapeshop.entity.CompanyEntity;
import com.shapeshop.entity.OrderEntity;
import com.shapeshop.repository.CompanyRepository;
import com.shapeshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

//			List<CompanyEntity> result = StreamSupport.stream(cRes.findAll().spliterator(), false)
//					.collect(Collectors.toList());
			CompanyEntity result = cRes.findByName("higgins");

			System.out.println("Hello hello 5");

			System.out.println("CompanyEntity ! " + (result != null ? result.toString() : " no higgins"));
		};
	}
}
