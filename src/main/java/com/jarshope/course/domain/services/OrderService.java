package com.jarshope.course.domain.services;

import java.util.List;
import java.util.Optional;

import com.jarshope.course.domain.model.Order;
import com.jarshope.course.domain.repositories.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> findAll() {
		return orderRepository.findAll();
	}
	
	public Order findById(Long orderId) {
		Optional<Order> obj = orderRepository.findById(orderId);
		return obj.get();
	}
	
}
