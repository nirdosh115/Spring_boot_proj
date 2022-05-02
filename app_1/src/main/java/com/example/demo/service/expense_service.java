package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.expense_entity;
import com.example.demo.entity.user_entity;

public interface expense_service {

	List<user_entity> getAllUsers();

	List<expense_entity> getEntityforUser(Long id);

	user_entity addUser(user_entity new_user);
	
	expense_entity addExpenseByUserId(Long id, expense_entity ex);

	user_entity update_user(long user_id,user_entity user);

	void delete_expense(Long id);

	void delete_user(Long id);

	List<expense_entity> getByCategory(String category);

	String getTotalExpense(Long id);

}
