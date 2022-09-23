package com.jarshope.course.config;

import java.time.Instant;
import java.util.Arrays;

import com.jarshope.course.domain.model.Category;
import com.jarshope.course.domain.model.Order;
import com.jarshope.course.domain.model.User;
import com.jarshope.course.domain.model.enums.OrderStatus;
import com.jarshope.course.domain.repositories.CategoryRepository;
import com.jarshope.course.domain.repositories.OrderRepository;
import com.jarshope.course.domain.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		// while the app start 
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.now(),OrderStatus.SHIPPED , u1);
		Order o2 = new Order(null, Instant.now(),OrderStatus.PAID, u2);
		Order o3 = new Order(null, Instant.now(),OrderStatus.CANCELED, u1);
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
	}
	
	
	
	
	
}
