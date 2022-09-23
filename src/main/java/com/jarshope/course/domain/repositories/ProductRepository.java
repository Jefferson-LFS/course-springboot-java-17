package com.jarshope.course.domain.repositories;

import com.jarshope.course.domain.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
