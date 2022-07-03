package com.simplilearn.assigment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.assigment.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
}
