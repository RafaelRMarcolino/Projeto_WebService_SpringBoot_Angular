package com.backend.spring.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.backend.spring.entities.Product;

public class ProductDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message = "Necessario prencher o nome")
	private String name;
	
	@NotEmpty(message =  "Necessario prencher o preço")
	private double price;
	
	public ProductDto() {
		
	}
	
	public ProductDto(Product obj) {
		id = obj.getId();
		name = obj.getName();
		price = obj.getPrice();
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
