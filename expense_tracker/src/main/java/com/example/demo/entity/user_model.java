package com.example.demo.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class user_model {
	@NotBlank(message="Provide First Name")
	private String f_name;
	@NotBlank(message="Provide Last Name")
	private String l_name;
	@NotNull(message="Provide password Name")
	@Size(min=6, message="Password must contain atleast 6 characters")
	private String password;
	@NotNull(message="provide Valid Email")
	@Email
	private String email;
	
	private long age=0L;
	
}
