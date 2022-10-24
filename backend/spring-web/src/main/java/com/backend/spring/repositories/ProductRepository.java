package com.backend.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.spring.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
