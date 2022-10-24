package com.backend.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.spring.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer > {

}
