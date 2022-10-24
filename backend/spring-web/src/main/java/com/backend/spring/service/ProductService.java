package com.backend.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.spring.entities.Product;
import com.backend.spring.exception.ObjectNotFoundException;
import com.backend.spring.repositories.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repo;
	
	public List<Product> getAllProduct() {
		
		return repo.findAll();
	}

	public Product getByIdProduct(Integer id) {
		
		Optional<Product> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException( "Objeto nao encontrado " + obj.getClass()));
	}

}
