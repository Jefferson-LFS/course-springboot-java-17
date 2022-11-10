package com.jarshope.course.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarshope.course.domain.model.User;
import com.jarshope.course.domain.repositories.UserRepository;


@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(Long userId) {
		Optional<User> obj = userRepository.findById(userId);
		return obj.get();
	}
	
	public User update(Long userId, User user) {
		User entity = userRepository.getReferenceById(userId);
		updateData(entity, user);
		return userRepository.save(entity);
	}
	private void updateData(User entity, User user) {
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());
		
	}

	public User insert(User user) {
		return userRepository.save(user);
	}
	
	public void delete(Long userId) {
		   userRepository.deleteById(userId);
	}
}
