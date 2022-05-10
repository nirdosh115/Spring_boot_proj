package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.product_category;
import com.example.demo.entity.product_entity;

public interface prod_category_repo extends JpaRepository<product_category, Long> {

}
