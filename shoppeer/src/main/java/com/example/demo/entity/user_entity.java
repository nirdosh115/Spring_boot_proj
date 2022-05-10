package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name="user_table")
public class user_entity {
	@Id
	private Long phone;
	@NotNull
	@Column(name="user_name")
	private String name;
	@NotNull
	@Column(name="user_address")
	private String address;
	@NotNull
	@Column(name="user_password")
	private String password;
	@NotNull
	@Column(name="user_email")
	private String email;
	@NotNull
	@Column(name="user_dob")
	private Date dob;
	
	
	
	
}
