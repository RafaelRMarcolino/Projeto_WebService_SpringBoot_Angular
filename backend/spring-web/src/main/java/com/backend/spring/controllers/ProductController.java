package com.backend.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.spring.entities.Product;
import com.backend.spring.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private  ProductService service;
	
	@GetMapping("/product")
	public List<Product> getAllProduct(){
		
		return service.getAllProduct();
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getByIdProduct(@PathVariable Integer id){
		
		Product obj =  service.getByIdProduct(id);
		return ResponseEntity.ok().body(obj);
		
		
	}

	
}
