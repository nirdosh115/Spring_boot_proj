package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.authModel;
import com.example.demo.entity.jwtresponse;
import com.example.demo.entity.user;
import com.example.demo.entity.user_model;
import com.example.demo.security.customUserDetailService;
import com.example.demo.service.userService;
import com.example.demo.util.jwtTokenUtil;

@RestController
public class authcontroller {
	@Autowired
	userService userserv;
	@Autowired
	private customUserDetailService userDetailService;
	@Autowired
	private AuthenticationManager authManager;
	@Autowired
	private jwtTokenUtil jwtTokenUtil;
	@PostMapping("/login")
	public ResponseEntity<jwtresponse> login(@RequestBody authModel authModel ) throws Exception{
			Authentication authentication=this.authManager.authenticate(new UsernamePasswordAuthenticationToken(authModel.getEmail(),authModel.getPassword()));
			authenticate(authModel.getEmail(),authModel.getPassword());
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			final UserDetails  userdetails= userDetailService.loadUserByUsername(authModel.getEmail());
			final String token=jwtTokenUtil.generateToken(userdetails);
			return new ResponseEntity<jwtresponse>(new jwtresponse(token) ,HttpStatus.OK);
	}
	
	private void authenticate(String email, String password) throws Exception {
		// TODO Auto-generated method stub
		try {
			authManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
		}
		catch(DisabledException e) {
			throw new Exception("User Disabled");
			
		}
		catch (BadCredentialsException e) {
			// TODO: handle exception
			throw new Exception("Bad Credential");
		}
		
	}

	@PostMapping("/register")
	public ResponseEntity<user> save(@Valid @RequestBody user_model user) {
		return new ResponseEntity<user> (this.userserv.createUser(user),HttpStatus.CREATED);
	}
	
}
