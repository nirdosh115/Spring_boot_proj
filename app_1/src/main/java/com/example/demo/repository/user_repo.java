package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.expense_entity;
import com.example.demo.entity.user_entity;

public interface user_repo extends JpaRepository<user_entity, Long>{

}
