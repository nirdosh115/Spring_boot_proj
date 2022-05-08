package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.expense_entity;
@Repository
public interface expense_repo extends JpaRepository<expense_entity, Long>{

	List<expense_entity> findByCategory(String category);
	
	@Query("Select SUM(u.amount) from expense_entity u where u.user_id= :n")
	String AddExpenseByUserId(@Param(value = "n") Long n); 
}
