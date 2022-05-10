package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="prod_tabel")
public class product_entity {

	@Id
	@Column(name="prod_id")
	private Long id;
	
	@NotBlank
	@Column(name="prod_name")
	private String name;
	
	@NotBlank
	@Column(name="prod_desc")
	private String desc;
	
	@Column(name="prod_color")
	private String color;
	@NotNull
	@Column(name="prod_price")
	private Long price;
	
	
	@Column(name="category_id")
		private Long category_id;
}
