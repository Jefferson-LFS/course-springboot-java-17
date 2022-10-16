package com.jarshope.course.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jarshope.course.domain.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
