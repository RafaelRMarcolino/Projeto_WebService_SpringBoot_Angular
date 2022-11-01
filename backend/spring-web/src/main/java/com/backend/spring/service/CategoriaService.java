package com.backend.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.spring.entities.Category;
import com.backend.spring.exception.ObjectNotFoundException;
import com.backend.spring.repositories.CategoryRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoryRepository repo;
	
	public List<Category> getAllCategory() {
		
		return repo.findAll();
	}

	public Category getByIdCategory(Integer id) {
		
		Optional<Category> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException( "Objeto não encontrado " + obj.getClass()));
	}
	
	
	
	public Category insertCategory(Category obj) {
		
			return repo.save(obj);
	}
	
	public Category updateCategory(Category obj) {
		
		 obj = getByIdCategory(obj.getId());
		return repo.save(obj);
	}

	
	public void deletarCategory(Integer id) {
		
		repo.deleteById(id);
	}
	
	

	
	

}
