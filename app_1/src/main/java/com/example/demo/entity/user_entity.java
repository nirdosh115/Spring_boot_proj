package com.example.demo.entity;

import java.text.NumberFormat.Style;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user_tbl")
public class user_entity {

	@Id
	private long user_id;
	@NotBlank(message="Name must not by empty")
	@Size(min=4, message="Invalid name")
	private String name;
	@NotBlank(message ="Email must not be blank")
	@Email(message ="enter valid mail")
	private String email;
	
	@NotBlank(message="enter phone number")
	private String phone_number;
	
	private String address;	
	@OneToMany(targetEntity = expense_entity.class, cascade=CascadeType.ALL)
	@JoinColumn(name="ex_fk", referencedColumnName = "user_id")
	@JsonIgnore
	private List<expense_entity> exp;
}
