package com.simplilearn.assigment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.assigment.model.Product;
import com.simplilearn.assigment.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public ProductServiceImpl() {}
	
	
	
	/**
	 * @param productRepository
	 */
	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}



	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product save(Product theProduct) {
		// TODO Auto-generated method stub
		return productRepository.save(theProduct);
	}

	@Override
	public Product findById(long theProduct) {
		// TODO Auto-generated method stub
		return productRepository.findById(theProduct).get();
	}

	@Override
	public Product deleteById(long theProduct) {
		// TODO Auto-generated method stub
		
		productRepository.deleteById(theProduct);
		
		return null;
	}

}
