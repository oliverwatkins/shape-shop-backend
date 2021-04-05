package com.shapeshop;

import com.shapeshop.entity.AddressEntity;
import com.shapeshop.entity.CompanyEntity;
import com.shapeshop.entity.CreditCardEntity;
import com.shapeshop.entity.UserEntity;
import com.shapeshop.mockdata.Alpenhof;
import com.shapeshop.mockdata.Higgins;
import com.shapeshop.model.UserRole;
import com.shapeshop.repository.*;
import com.shapeshop.util.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

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
}
