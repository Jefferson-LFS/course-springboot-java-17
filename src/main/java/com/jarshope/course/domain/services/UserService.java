package com.jarshope.course.domain.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.jarshope.course.domain.excepitons.DatabaseException;
import com.jarshope.course.domain.excepitons.ResourceNotFoundException;
import com.jarshope.course.domain.model.User;
import com.jarshope.course.domain.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;


@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(Long userId) {
		Optional<User> obj = userRepository.findById(userId);
		return obj.orElseThrow(() -> new ResourceNotFoundException(userId));
	}
	
	public User update(Long userId, User user) {
		try {
			User entity = userRepository.getReferenceById(userId);
			updateData(entity, user);
			return userRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(userId);
		}
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
		try {
			
			userRepository.deleteById(userId);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(userId);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		
	}
}
