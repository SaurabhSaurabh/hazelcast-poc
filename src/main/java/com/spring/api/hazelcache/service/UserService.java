package com.spring.api.hazelcache.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.spring.api.hazelcache.dao.UserRepository;
import com.spring.api.hazelcache.model.User;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	@Cacheable(cacheNames= {"userCache"})
	public List<User> getUsers()
	{
		System.out.println("Hit DB first time in getUsers()..");
		return repository.findAll();
	}
	
	@Cacheable(value="userCache", key="#id", unless="#result==null")
	public Optional<User> getUser(int id)
	{
		System.out.println("Hit DB first time in getUser()..");
		return repository.findById(id);
	}
	
	@CacheEvict(value="userCache")
	public void deleteUser(int id)
	{
		repository.deleteById(id);
		System.out.println("User deleted with id :" + id);
	}
}
