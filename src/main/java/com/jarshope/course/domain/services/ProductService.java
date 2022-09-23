package com.jarshope.course.domain.services;

import java.util.List;
import java.util.Optional;

import com.jarshope.course.domain.model.Product;
import com.jarshope.course.domain.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll() {
		return productRepository.findAll();
	}
	
	public Product findById(Long productId) {
		Optional<Product> obj = productRepository.findById(productId);
		return obj.get();
	}
	
}
