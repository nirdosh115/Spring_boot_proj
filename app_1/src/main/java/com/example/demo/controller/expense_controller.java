package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.expense_entity;
import com.example.demo.entity.user_entity;
import com.example.demo.service.expense_service;
import com.example.demo.service.user_service;

@RestController
public class expense_controller {
	@Autowired
	private expense_service service;
	
	@Autowired
	private user_service service2;
	
		
	@GetMapping("/user")
	public ResponseEntity<List<user_entity>> home(){
				return new ResponseEntity<List<user_entity>>(this.service.getAllUsers(),HttpStatus.ACCEPTED);
	}

	@GetMapping("/expenses/{id}")
	public ResponseEntity<List<expense_entity>> user(@PathVariable Long id){
		return new ResponseEntity<List<expense_entity>>(this.service.getEntityforUser(id),HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/user")
	public ResponseEntity<user_entity> addUser(@Valid @RequestBody user_entity new_user){
		
		return new  ResponseEntity<user_entity>(this.service.addUser(new_user),HttpStatus.CREATED);
		
	}
	
	@PostMapping("/expenses/{id}")
	public ResponseEntity<expense_entity> addExpenseByUserId(@PathVariable Long id,@RequestBody expense_entity ex){
		
		return new ResponseEntity<expense_entity> (this.service.addExpenseByUserId(id, ex),HttpStatus.OK);
	}
	
	@PostMapping("/edit/expenses")
	public ResponseEntity<expense_entity> update_expensne(@RequestParam long exp_id,@RequestBody  expense_entity ex){
		
		return new ResponseEntity<expense_entity>(this.service2.update_expense(exp_id,ex),HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/edit/user")
	public ResponseEntity<user_entity> update_user (@RequestParam long user_id, @RequestBody user_entity user){
		
		return new ResponseEntity<user_entity>(this.service.update_user(user_id,user),HttpStatus.OK);
	}
	
	@DeleteMapping("/expenses/{id}")
	public String delete_expense(@PathVariable Long id) {
			this.service.delete_expense(id);
		return "Expense Deleted Successfully";
	}
	
	@DeleteMapping("/user/{id}")
	public String delete_User(@PathVariable Long id) {
		this.service.delete_user(id);		
		return null;
	}
	
	@GetMapping("expenses")
	public ResponseEntity<List<expense_entity>> getByCategory(@RequestParam String category){
				
		return new ResponseEntity<List<expense_entity>>(this.service.getByCategory(category),HttpStatus.OK);
		
		
	}
	
	
	@GetMapping("/GetTotal/{id}")
	public String getTotalExpense(@PathVariable Long id) {
		return this.service.getTotalExpense(id);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
