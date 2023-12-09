package com.emsi.inventoryservice;

import com.emsi.inventoryservice.entities.Product;
import com.emsi.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductRepository productRepository){
		return args -> {
			productRepository.saveAll(List.of(
					Product.builder()
							.name("CR Mercurial Vapor Superfly 2")
							.price(6000)
							.build(),
					Product.builder()
							.name("Nike Mercurial Superfly 6")
							.price(7000)
							.build(),
					Product.builder()
							.name("CR Mercurial Vapor 9")
							.price(8000)
							.build()
			));

			productRepository.findAll().forEach(System.out::println);
		};
	}
}
