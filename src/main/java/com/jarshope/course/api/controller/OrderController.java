package com.jarshope.course.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jarshope.course.domain.model.Order;
import com.jarshope.course.domain.services.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List<Order> list = orderService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{OrderId}")
	public ResponseEntity<Order> findById(@PathVariable Long OrderId) {
		Order obj = orderService.findById(OrderId);
		return ResponseEntity.ok().body(obj); 
			
	}
	
	
}
