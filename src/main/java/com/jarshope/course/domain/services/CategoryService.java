package com.jarshope.course.domain.services;

import java.util.List;
import java.util.Optional;

import com.jarshope.course.domain.model.Category;
import com.jarshope.course.domain.repositories.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}
	
	public Category findById(Long categoryId) {
		Optional<Category> obj = categoryRepository.findById(categoryId);
		return obj.get();
	}
	
}
