package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class login_entity {
	
	@Id
	@NotNull
	private Long userId;
	@NotBlank
	@Size(min=6, message="enter Strong password")
	private String password;
}
