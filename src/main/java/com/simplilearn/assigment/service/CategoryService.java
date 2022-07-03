package com.simplilearn.assigment.service;

import java.util.List;

import com.simplilearn.assigment.model.Category;

public interface CategoryService {

	public List<Category> findAll();
	public Category save(Category theCategory);
	public Category findById(long theCategory);
	public Category deleteById(long theCategory);

}
