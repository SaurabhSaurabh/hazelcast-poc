package com.spring.api.hazelcache.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.api.hazelcache.model.User;

public interface UserRepository extends JpaRepository<User,Integer>{

}
