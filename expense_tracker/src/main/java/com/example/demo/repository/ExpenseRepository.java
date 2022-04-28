package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.expense;

@Repository
public interface ExpenseRepository extends JpaRepository<expense,Long> {

	Page< expense> findByCategory(String Category, Pageable page);
	Page<expense> findByNameContaining(String Keyword, Pageable page);
	Page <expense> findByUserId(Long userId, Pageable page);
	Optional<expense> findByUserIdAndId(Long userId, Long Id);
}
