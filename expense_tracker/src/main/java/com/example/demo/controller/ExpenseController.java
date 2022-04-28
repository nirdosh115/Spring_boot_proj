package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.expense;
import com.example.demo.service.ExpenseService;


@RestController
public class ExpenseController {
	@Autowired
	private ExpenseService expservice;
	@GetMapping("/expenses")
	public List<expense> getAllExpenses(Pageable page) {
		return expservice.getAllExpense(page);
	
	}
	
	
	@GetMapping("/expenses/{id}")
	public expense getExpensesById(@PathVariable("id") long id) {
		return expservice.getExpensesById(id);
	}

	@ResponseStatus(value=HttpStatus.CREATED)
	@PostMapping("/expenses")
	public expense saveExpenseDetails(@Valid @RequestBody expense expense) {
		return expservice.saveExpenseDetails(expense);
	}
	
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	@DeleteMapping("/expenses")
	public void deleteExpenseById(@RequestParam("id") long id) {
		expservice.deleteExpenseById(id);
		
	}
	
	@PostMapping("/expenses/{id}")
	public expense updateExpenseDetails(@PathVariable("id") long id, @RequestBody expense expense) {		
		return this.expservice.updateExpenseDetails(id,expense);
	}
	
	@GetMapping("/expenses/category")
	public List<expense> getByCategory(@RequestParam String category, Pageable page){
		return this.expservice.getByCategory(category, page);
	}
	
	@GetMapping("/expenses/name")
	public List<expense>  getByName(@RequestParam String keyword,Pageable page){
		
		return this.expservice.getByName(keyword, page);
	}
	
}
