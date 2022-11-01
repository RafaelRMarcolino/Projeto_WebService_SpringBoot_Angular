package com.backend.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.spring.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer > {

}
