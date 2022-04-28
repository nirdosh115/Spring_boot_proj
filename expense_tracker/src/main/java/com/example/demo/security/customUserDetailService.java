package com.example.demo.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.user;
import com.example.demo.repository.userRepository;


@Service
public class customUserDetailService implements UserDetailsService {

	@Autowired
	userRepository userrepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		user existing_user=this.userrepo.findByEmail(username).orElseThrow(()->new UsernameNotFoundException("User Not found with email "+username));
	
	return	new User(existing_user.getEmail(), existing_user.getPassword(),new ArrayList<>());
	}

}
