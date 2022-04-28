package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="family")
public class family {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int Id;
	private String fname;
	private String lname;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public family(int id, String fname, String lname) {
		super();
		Id = id;
		this.fname = fname;
		this.lname = lname;
	}
	public family() {
		super();
		// TODO Auto-generated constructor stub
	}



}
