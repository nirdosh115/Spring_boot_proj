package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.product_entity;
import com.example.demo.entity.product_type;

public interface product_repo  extends JpaRepository<product_entity, Long>{

}
