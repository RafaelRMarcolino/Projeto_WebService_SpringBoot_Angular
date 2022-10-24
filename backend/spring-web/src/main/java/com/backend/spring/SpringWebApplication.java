package com.backend.spring;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.backend.spring.entities.Category;
import com.backend.spring.entities.Product;
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

		Category cat = new Category(null, "Metal");
		Product pro1 = new Product(null, "polo", 250);
		
		cat.getProduct().addAll(Arrays.asList(pro1));
		pro1.getCategory().addAll(Arrays.asList(cat));
		
		catRepo.save(cat);
		prodRepo.save(pro1);
		
	}

}
