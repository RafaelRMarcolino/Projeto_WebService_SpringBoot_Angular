package com.backend.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.spring.dto.ProductDto;
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
		return obj.orElseThrow(() -> new ObjectNotFoundException( "Objeto não encontrado " + obj.getClass()));
	}
	
	
	
	public Product insertProduct(Product obj) {
		
			return repo.save(obj);
	}
	
	public Product updateProduct(Product obj) {
		
		Product objDto = getByIdProduct(obj.getId());
		updateData(objDto, obj);
		return repo.save(obj);
	}

	
	public void deletarProduct(Integer id) {
		
		repo.deleteById(id);
	}
	
	
	public Product fromDTO (ProductDto objDto) {
		
		return new Product(objDto.getId(), objDto.getName(), objDto.getPrice());
	}
	
	
	public void updateData (Product newObj, Product obj) {
		
		newObj.setName(obj.getName());
		newObj.setPrice(obj.getPrice());
	}
	
	
	

}
