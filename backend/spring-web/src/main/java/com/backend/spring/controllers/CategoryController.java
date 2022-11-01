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

import com.backend.spring.entities.Category;
import com.backend.spring.service.CategoriaService;

@RestController
@RequestMapping("/api")
public class CategoryController {
	
	@Autowired
	private  CategoriaService service;
	
	@GetMapping("/Category")
	public List<Category> getAllCategory(){
		
		return service.getAllCategory();
	}
	
	@GetMapping("/Category/{id}")
	public ResponseEntity<Category> getByIdCategory(@PathVariable Integer id){
		
		Category obj =  service.getByIdCategory(id);
		return ResponseEntity.ok().body(obj);
	}


	@PostMapping("/Category")
	public ResponseEntity<Void> insertCategory(@RequestBody @Valid Category obj){
		
		obj = service.insertCategory(obj);
		URI uri =  ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();	
	}

	
	@PutMapping("/Category/{id}")
	public ResponseEntity<Void> updateCategory(@Valid @RequestBody  Category obj,  @PathVariable Integer id){
		
		obj.setId(id);
		obj = service.updateCategory(obj);
		return ResponseEntity.noContent().build();
		
	}

	@DeleteMapping("/Category/{id}")
	public ResponseEntity<Category> deletCategory(@PathVariable Integer id){
		
		service.deletarCategory(id);
		return ResponseEntity.noContent().build();
	}

}
