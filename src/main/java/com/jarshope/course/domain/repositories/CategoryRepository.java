package com.jarshope.course.domain.repositories;

import com.jarshope.course.domain.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
