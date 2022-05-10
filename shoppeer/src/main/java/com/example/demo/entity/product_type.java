package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.websocket.OnClose;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Data
@Entity
@Table(name="prod_type_table")
public class product_type {
	
	@Id
	@Column(name="product_type_id")
	private Long id;
	@NotBlank
	@Column(name="product_type_name")
	private String name;
	
	@NotBlank
	@Column(name="prod_type_desc")
	private String desc;
	
	
	@OneToMany(targetEntity = product_category.class, cascade=CascadeType.ALL)
	@JoinColumn(name="type_id", referencedColumnName = "product_type_id")
	@JsonIgnore
	private List<product_category> product_category;
}
