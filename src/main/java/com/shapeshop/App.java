package com.shapeshop;


import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.shapeshop.model.Shape2;
import com.shapeshop.repository.ShapeRepository;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }
    
    

    @Bean
    public CommandLineRunner demo(ShapeRepository repository) {
      return (args) -> {
    	  
        // save a few shapes
        repository.save(new Shape2(1, 3));
        repository.save(new Shape2(2, 5));
        repository.save(new Shape2(3, 6));
        repository.save(new Shape2(4, 7));

        // fetch an individual customer by ID
        Shape2 sh1 = repository.findById(2L);
        System.out.println("fetch by id " + sh1.toString());

        // fetch customers by last name
        repository.findBySides(7).forEach(sh -> {
            System.out.println("fetch by sides " + sh.toString());
        });
      };
    }

}