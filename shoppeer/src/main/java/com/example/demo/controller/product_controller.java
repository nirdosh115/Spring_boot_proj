package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.product_category;
import com.example.demo.entity.product_entity;
import com.example.demo.entity.product_type;

import com.example.demo.service.product_service;

@RestController
public class product_controller {
	
	@Autowired
	product_service service;
	
	@PostMapping("/addType")
	public String addType(@RequestBody product_type type) {
		return this.service.addType(type);
	}
	
	@PostMapping("/addCategory")
	public String addCategory(@RequestBody product_category category, @RequestParam Long type) {
		
		return this.service.addCategory(category, type);
	}
	
	
	@PostMapping("/addProduct")
	public product_entity addProduct(@RequestBody product_entity product, @RequestParam Long category) {
		
		return this.service.addProduct(product, category);
		
	}
	
	@GetMapping("/getTypes")
	public List<product_type> getTypes() {
		
		return this.service.getTypes();
	}
	
	@GetMapping("/getCategory")
	public List<product_category> getCategory(@RequestParam Long type){
		
		return this.service.getCategory(type);
	}
	
	@GetMapping("/getProduct")
	public List<product_entity> getProduct(@RequestParam Long category){
		
		return this.service.getProduct(category);
	}
	
	@DeleteMapping("/deleteType/{id}")
	public String delete_type(@PathVariable Long id) {		
		return this.service.deleteType(id);
	}
	
	
	@DeleteMapping("/deleteCategory/{id}")
	public String delete_Category(@PathVariable Long id) {		
		return this.service.deleteCategory(id);
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public String delete_Product(@PathVariable Long id) {		
		return this.service.deleteProduct(id);
	}
	
	
	@RequestMapping(value="/updateType", method = RequestMethod.POST)
	public String updateType( @RequestBody product_type prod_type) {
		return this.service.updateType(prod_type);
	}
	
	
	
	@RequestMapping(value="/updateCategory", method = RequestMethod.POST)
	public String updateCategory( @RequestBody product_category prod_category) {
		return this.service.updateType(prod_category);
	}
	
	@RequestMapping(value="/updateProduct", method = RequestMethod.POST)
	public String updateProduct( @RequestBody product_entity prod) {
		return this.service.updateProduct(prod);
	}
	
	
	
	
	
	
	
	
}
