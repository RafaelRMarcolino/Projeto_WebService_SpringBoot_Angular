package com.backend.spring.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.backend.spring.dto.ProductDto;
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


	@PostMapping("/product")
	public ResponseEntity<Void> insertProduct(@RequestBody @Valid Product obj){
		
		obj = service.insertProduct(obj);
		URI uri =  ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();	
	}

	
	@PutMapping("/product/{id}")
	public ResponseEntity<Void> updateProduct(@Valid @RequestBody  ProductDto objDto,  @PathVariable Integer id){
		
		Product obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.updateProduct(obj);
		return ResponseEntity.noContent().build();
		
	}

	@DeleteMapping("/product/{id}")
	public ResponseEntity<Product> deletProduct(@PathVariable Integer id){
		
		service.deletarProduct(id);
		return ResponseEntity.noContent().build();
	}

	
	

}
