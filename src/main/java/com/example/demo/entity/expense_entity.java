package com.example.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="expense_tbl1")
public class expense_entity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long expid;

	private String category;
	private String amount;
	private Date date;
	private String description;
	@Column(name="ex_fk")
	@JsonIgnore
	private Long user_id;
	
}
