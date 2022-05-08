
package com.example.demo.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.expense_entity;
import com.example.demo.entity.show_user;
import com.example.demo.entity.user_entity;
import com.example.demo.exceptions.genericException;
import com.example.demo.repository.expense_repo;
import com.example.demo.repository.user_repo;

@Service
public class expense_service_impl implements expense_service {
	@Autowired
	private expense_repo repo;
	@Autowired
	private user_repo repo1;
	
	

	@Override
	public List<user_entity> getAllUsers(String Admin) {
		if (Admin.equals("@Adminpassword")==false) {
			throw new genericException("Authorization Failed");
		}
		// TODO Auto-generated method stub
		if (this.repo1.findAll().isEmpty()) {
			throw new genericException("No User Present");
		}
		 List<user_entity> u= this.repo1.findAll();
			 
		 return u;
	}

	@Override
	public List<expense_entity> getEntityforUser(Long id) {
		if (this.repo1.findById(id).isEmpty()) {
			throw new genericException("Invalid User");
		}
		user_entity user= this.repo1.getById(id);
		return user.getExp();
	}

	@Override
	public show_user addUser(user_entity new_user) {
		
		long id =new_user.getUser_id();
		if (this.repo1.findById(id).isPresent()) {
			throw new genericException("User Already Exists");
		}
		
		
		user_entity u=this.repo1.save(new_user);
		show_user su =  new show_user();
		BeanUtils.copyProperties(u, su);
		return su;
	}

	@Override
	public expense_entity addExpenseByUserId(Long id, expense_entity ex) {
		if (this.repo1.findById(id).isEmpty()) {
			throw new genericException("User not found");
		}
		expense_entity exp=new expense_entity();
		exp.setUser_id(id);		
		exp.setAmount(ex.getAmount());
		exp.setCategory(ex.getCategory());
		exp.setDate(ex.getDate());
		return this.repo.save(exp);
	}

	@Override
	public user_entity update_user(long user_id, user_entity u) {
		if (this.repo1.findById(user_id).isEmpty()) {
			throw new genericException("user not found");
		}
		user_entity user= this.repo1.getById(user_id);
		user.setUser_id(u.getUser_id()!=0L?u.getUser_id():user.getUser_id());
		user.setName(u.getName()!=null?u.getName():user.getName());
		user.setEmail(u.getEmail()!=null?u.getEmail():user.getEmail());
		user.setPhone_number(u.getPhone_number()!=null?u.getPhone_number():user.getPhone_number());
		user.setAddress(u.getAddress()!=null?u.getAddress():user.getAddress());
		
		return this.repo1.save(user);
	}

	@Override
	public void delete_expense(Long id) {
		
		if(this.repo.findById(id).isEmpty()) {
			throw new genericException("Invalid expense id");
		}
		// TODO Auto-generated method stub
		this.repo.deleteById(id);
				
	}

	@Override
	public void delete_user(Long id) {
		// TODO Auto-generated method stub
		if (this.repo1.findById(id).isEmpty()) {
			throw new genericException("User not present");
		}
		this.repo1.deleteById(id);
	}

	@Override
	public List<expense_entity> getByCategory(String category) {
		// TODO Auto-generated method stub
		return this.repo.findByCategory(category);
		
	}

	@Override
	public String getTotalExpense(Long id) {
		// TODO Auto-generated method stub
		String total=this.repo.AddExpenseByUserId(id);
		
		return "Total expense:" + total;
	}

	
	
}
