package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.expense_entity;
import com.example.demo.entity.user_entity;
import com.example.demo.repository.expense_repo;

@Service
public class user_service_impl implements user_service {
	
	@Autowired
	private expense_repo repo;

	
	@Override
	public expense_entity update_expense( long exp_id, expense_entity ex) {
		
		expense_entity exp=this.repo.findById(exp_id).get();
		exp.setAmount(ex.getAmount()!=null?ex.getAmount():exp.getAmount());
		exp.setCategory(ex.getCategory()!=null?ex.getCategory():exp.getCategory());				
		return this.repo.save(exp);
	}
}
