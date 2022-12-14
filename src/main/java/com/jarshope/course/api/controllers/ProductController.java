package com.jarshope.course.api.controllers;

import java.util.List;

import com.jarshope.course.domain.model.Product;
import com.jarshope.course.domain.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = productService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{productId}")
	public ResponseEntity<Product> findById(@PathVariable Long productId) {
		Product obj = productService.findById(productId);
		return ResponseEntity.ok().body(obj); 
			
	}
	
	
}
