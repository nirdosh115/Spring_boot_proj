package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.example.demo.entity.expense;

public interface ExpenseService {
	 List<expense> getAllExpense(Pageable page);

	 expense getExpensesById(long id);

	 void deleteExpenseById(long id);

	expense saveExpenseDetails(expense expense);

	expense updateExpenseDetails(long id, expense expense);

	List<expense> getByCategory(String Category, Pageable page);
	
	List<expense> getByName(String keyword,Pageable page);
	
	
}
