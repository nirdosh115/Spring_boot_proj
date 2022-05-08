package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Data
@Entity
public class show_user {
	@Id
	private long user_id;
	private String name;
	@JsonIgnore
	private String password;
	private String email;
	
	private String phone_number;
	
	private String address;	
	@OneToMany(targetEntity = expense_entity.class, cascade=CascadeType.ALL)
	@JoinColumn(name="ex_fk", referencedColumnName = "user_id")
	@JsonIgnore
	private List<expense_entity> exp;
}
