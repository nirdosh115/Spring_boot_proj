package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.user;
import com.example.demo.entity.user_model;
import com.example.demo.service.userService;

@Controller
public class userController {
	@Autowired
	userService userserv;
	
	
	
	@GetMapping("/profile")
	public ResponseEntity<user> getUser(){
		return new ResponseEntity<user> (this.userserv.readUser(), HttpStatus.FOUND);
	}
	
	@PostMapping("/profile")
	public ResponseEntity<user> updateUser( @RequestBody user_model user){		
		
		return new ResponseEntity<user> (this.userserv.updateUser(user),HttpStatus.OK);
	}
	
	@DeleteMapping("/deactivate")
	public ResponseEntity<String> deleteUser(){		
		return new ResponseEntity<String>(this.userserv.deleteUser(), HttpStatus.NO_CONTENT);
	}
}
