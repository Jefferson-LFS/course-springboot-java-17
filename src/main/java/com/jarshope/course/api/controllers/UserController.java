package com.jarshope.course.api.controllers;

import java.net.URI;
import java.util.List;

import com.jarshope.course.domain.model.User;
import com.jarshope.course.domain.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = userService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> findById(@PathVariable Long userId) {
		User obj = userService.findById(userId);
		return ResponseEntity.ok().body(obj); 
			
	}
	
	@PostMapping
	public  ResponseEntity<User> adicionar(@RequestBody User user) {
		User obj = userService.insert(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				  .buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj); 
	
	}
	
	
	@PutMapping("/{userId}")
	public ResponseEntity<User>  updadate(@PathVariable Long userId, @RequestBody User user){
		user = userService.update(userId, user);
		return ResponseEntity.ok().body(user);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<Void> delete(@PathVariable Long userId){
		userService.delete(userId);
		return ResponseEntity.noContent().build();
		
		
	}
	
}
