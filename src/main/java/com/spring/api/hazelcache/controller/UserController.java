package com.spring.api.hazelcache.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.api.hazelcache.model.User;
import com.spring.api.hazelcache.service.UserService;

@RestController
@RequestMapping("/cache-api")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.getUsers();
	}
	
	@GetMapping("/users/user/{id}")
	public User getUserById(@PathVariable("id") int id) {
		Optional<User> useroptional = userService.getUser(id);
		
		User user = useroptional.isPresent()?useroptional.get():useroptional.orElse(null);
		
		return user!=null?user:new User();
	}
	
	@DeleteMapping("/users/user/{id}")
	public void deleteById(@PathVariable int id)
	{
		userService.deleteUser(id);
	}
	
	
}
