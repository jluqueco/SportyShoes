package com.simplilearn.assigment.service;

import java.util.List;

import com.simplilearn.assigment.model.Product;


public interface ProductService {
	public List<Product> findAll();
	public Product save(Product theProduct);
	public Product findById(long theProduct);
	public Product deleteById(long theProduct);
}
