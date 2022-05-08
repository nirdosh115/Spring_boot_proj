package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.expense_entity;
import com.example.demo.entity.generic_exc_obj;
import com.example.demo.entity.login_entity;
import com.example.demo.entity.user_entity;
import com.example.demo.exceptions.genericException;
import com.example.demo.repository.expense_repo;
import com.example.demo.repository.user_repo;

@Service
public class user_service_impl implements user_service {
	
	@Autowired
	private expense_repo repo;
	
	@Autowired
	private user_repo repo1;

	
	@Override
	public expense_entity update_expense( long exp_id, expense_entity ex) {
		
		expense_entity exp=this.repo.findById(exp_id).get();
		exp.setAmount(ex.getAmount()!=null?ex.getAmount():exp.getAmount());
		exp.setCategory(ex.getCategory()!=null?ex.getCategory():exp.getCategory());				
		return this.repo.save(exp);
	}


	@Override
	public String login(login_entity lg) {
		Long a = null;
		// TODO Auto-generated method stub
		if (lg.getUserId()==null) {
			throw new genericException("Enter User ID");
		}
		
		if (this.repo1.findById(lg.getUserId()).isPresent()==false) {
			throw new genericException("Enter User not present ID");
		}
		else {
			user_entity user=this.repo1.findById(lg.getUserId()).get();
			if(user.getPassword().equals(lg.getPassword())) {
				return "User Logged In";
			}
			else {
				throw new genericException("Invalid Password");
			}
			
		}
		
		
	}
}
