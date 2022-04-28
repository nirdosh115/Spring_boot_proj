package com.example.demo.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.user;
import com.example.demo.entity.user_model;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.exceptions.itemAlreadyExistsException;
import com.example.demo.repository.userRepository;
@Service
public class userServiceImpl  implements userService{
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Autowired
	userRepository userrepo;
	
	@Override
	public user createUser(user_model user) {
		
		if (this.userrepo.existsByEmail(user.getEmail())) {
			throw new itemAlreadyExistsException("Email Already Present");
		}
		// TODO Auto-generated method stub
		user newUser= new user();
		BeanUtils.copyProperties(user, newUser);
		newUser.setPassword(bcryptEncoder.encode(newUser.getPassword()));
		return this.userrepo.save(newUser);
	}
	@Override
	public user readUser() {
		long id=getLoggedInUSer().getId();
		return this.userrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User with id "+id +" not found" ));
	}
	@Override
	public user updateUser( user_model user) {
		// TODO Auto-generated method stub
		long id=getLoggedInUSer().getId();
		user user1=this.userrepo.findById(id).get();
		user1.setF_name(user.getF_name()!=null?user.getF_name():user1.getF_name());
		user1.setL_name(user.getL_name()!=null?user.getL_name():user1.getL_name());
		user1.setEmail(user.getEmail()!=null?user.getEmail():user1.getEmail());
		user1.setPassword(user.getPassword()!=null?bcryptEncoder.encode(user.getPassword()):user1.getPassword());
		user1.setAge(user.getAge()!=0L ?user.getAge():user1.getAge()); 
		return this.userrepo.save(user1);
	}
	@Override
	public String deleteUser() {
		// TODO Auto-generated method stub
		long id=getLoggedInUSer().getId();
		this.userrepo.delete(readUser());
		return "Deleted Succesfully";
	}
	@Override
	public user getLoggedInUSer() {
		Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
		String email=authentication.getName();
		return userrepo.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("Member not present with email : "+ email));
				
	}

}
