package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.product_category;
import com.example.demo.entity.product_type;

public interface prod_type_repo  extends JpaRepository<product_type, Long>{

	
}
