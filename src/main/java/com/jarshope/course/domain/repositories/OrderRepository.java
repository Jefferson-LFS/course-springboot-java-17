package com.jarshope.course.domain.repositories;

import com.jarshope.course.domain.model.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long>{

	

}
