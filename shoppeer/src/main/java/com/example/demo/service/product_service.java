package com.example.demo.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.example.demo.entity.product_category;
import com.example.demo.entity.product_entity;
import com.example.demo.entity.product_type;


public interface product_service {

	String addType(product_type type);

	String addCategory(product_category category, Long type_id);

	product_entity addProduct(product_entity product, Long category);

	List<product_type> getTypes();

	List<product_category> getCategory(Long type);

	String deleteType(Long id);

	String deleteCategory(Long id);

	String deleteProduct(Long id);

	List<product_entity> getProduct(Long category);

	String updateType(product_type prod_type);

	String updateType(product_category prod_category);

	String updateProduct(product_entity prod);


	
}
