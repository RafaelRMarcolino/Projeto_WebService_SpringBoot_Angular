package com.backend.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.backend.spring.repositories.CategoryRepository;
import com.backend.spring.repositories.ProductRepository;

@SpringBootApplication
public class SpringWebApplication implements CommandLineRunner {

	@Autowired
	public CategoryRepository catRepo;
	
	@Autowired
	public ProductRepository prodRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringWebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	
	}

}
