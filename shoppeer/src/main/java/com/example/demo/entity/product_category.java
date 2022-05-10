package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="product_category")
public class product_category {
	
	@Id
	@Column(name="category_id")
	private Long  id;
	
	@NotBlank
	@Column(name="category_name")
	private String name;
	
	@NotBlank
	@Column(name="category_desc")
	private String desc;
	
	
	@OneToMany(targetEntity = product_entity.class, cascade=CascadeType.ALL)
	@JoinColumn(name="category_id", referencedColumnName = "category_id")
	@JsonIgnore
	private List<product_entity> product_entity;
	
	@Column(name="type_id")
	@JsonIgnore
	private Long type_id;
}
