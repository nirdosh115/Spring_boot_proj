package com.example.demo.service;

import org.springframework.http.ResponseEntity;

import com.example.demo.entity.user;
import com.example.demo.entity.user_model;

public interface userService {

	user createUser(user_model user);
	user readUser();
	user updateUser( user_model user);
	
	String deleteUser();
	
	user getLoggedInUSer();
	
}
