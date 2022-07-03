package com.simplilearn.assigment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.assigment.model.Category;
import com.simplilearn.assigment.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	
	
	/**
	 * 
	 */
	public CategoryServiceImpl() {
		super();
	}

	/**
	 * @param categoryRepository
	 */
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}
	
	

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public Category save(Category theCategory) {
		// TODO Auto-generated method stub
		return categoryRepository.save(theCategory);
	}

	@Override
	public Category findById(long theCategory) {
		// TODO Auto-generated method stub
		return categoryRepository.findById(theCategory).get();
	}

	@Override
	public Category deleteById(long theCategory) {
		// TODO Auto-generated method stub
		categoryRepository.deleteById(theCategory);
		
		return null;
	}

}
