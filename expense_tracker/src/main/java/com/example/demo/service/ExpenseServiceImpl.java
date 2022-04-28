package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.expense;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.repository.ExpenseRepository;


@Service
public class ExpenseServiceImpl implements ExpenseService{
	@Autowired
	private ExpenseRepository exrepo;
	
	@Autowired
	private userService userservice;
	@Override
	public List<expense> getAllExpense(Pageable page) {
		// TODO Auto-generated method stub
		
		return  (List<expense>) exrepo.findByUserId(userservice.getLoggedInUSer().getId(),page).toList();
	}
	@Override
	public expense getExpensesById(long id) {
		// TODO Auto-generated method stub
		Optional<expense> expens=exrepo.findByUserIdAndId(this.userservice.getLoggedInUSer().getId(), id);
		if (expens.isPresent()) {
			return expens.get();
		}
		throw new ResourceNotFoundException("Expense With id " +id+ " is not present");
	}
	@Override
	public void deleteExpenseById(long id) {
		expense exp=getExpensesById(id);
		this.exrepo.delete(exp);
	}
	
	
	@Override
	public expense saveExpenseDetails(expense expense) {
		// TODO Auto-generated method stub
		expense.setUser(this.userservice.getLoggedInUSer());		
		return this.exrepo.save(expense);
		
	}
	@Override
	public expense updateExpenseDetails(long id, expense expense) {
		// TODO Auto-generated method stub
		expense exp= getExpensesById(id);
		exp.setName(expense.getName()!=null?expense.getName():exp.getName());
		exp.setAmount(expense.getAmount()!=null?expense.getAmount():exp.getAmount());
		exp.setCategory(expense.getCategory()!=null?expense.getCategory():exp.getCategory());
		exp.setDescription(expense.getDescription()!=null?expense.getDescription():exp.getDescription());
		exp.setDate(expense.getDate()!=null?expense.getDate():exp.getDate());
		return this.exrepo.save(exp);
		
	}
	@Override
	public List<expense> getByCategory(String Category, Pageable page) {
		// TODO Auto-generated method stub
		return this.exrepo.findByCategory(Category, page).toList();
		
		
	}
	@Override
	public List<expense> getByName(String keyword, Pageable page) {
		
		return this.exrepo.findByNameContaining(keyword, page).toList();
	}
	
}
