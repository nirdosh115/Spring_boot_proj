package com.example.demo.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.generic_exc_obj;
import com.example.demo.entity.product_category;
import com.example.demo.entity.product_entity;
import com.example.demo.entity.product_type;
import com.example.demo.exceptions.genericException;
import com.example.demo.repository.prod_category_repo;
import com.example.demo.repository.prod_type_repo;
import com.example.demo.repository.product_repo;

@Service
public class product_service_imp implements product_service{
	@Autowired
	prod_type_repo repo;

	@Autowired
	prod_category_repo repo2;
	
	
	@Autowired
	product_repo repo3;
	
	@Override
	public String addType(product_type type) {
		if (this.repo.findById(type.getId()).isPresent()) {
			throw new genericException("Type already exists");
		}
		
		this.repo.save(type);
		return "type added successfully";
	}

	@Override
	public String addCategory(product_category category, Long type_id) {
		
		if(this.repo.findById(type_id).isEmpty()) {
			throw new genericException("Product Category Type doesn't exists");
		}
		
		if(this.repo2.findById(category.getId()).isPresent()) {
			throw new genericException("Categroy already exists");			
		}
		// TODO Auto-generated method stub
		product_category cat=new product_category();
		cat.setType_id(type_id);
		cat.setId(category.getId());
		cat.setName(category.getName());
		cat.setDesc(category.getDesc());
		this.repo2.save(cat);
		return "category added successfully";
	}

	@Override
	public product_entity addProduct(product_entity product, Long category) {
		if (this.repo2.findById(category).isEmpty()) {
			throw new genericException("Categroy doesn't  exists");		
		}
		// TODO Auto-generated method stub
		
		if(this.repo3.findById(product.getId()).isPresent()) {
			throw new genericException("Product already exists");
		}
		product_entity prod= new product_entity();
		prod.setCategory_id(category);
		prod.setColor(product.getColor());
		prod.setDesc(product.getDesc());
		prod.setId(product.getId());
		prod.setName(product.getName());
		prod.setPrice(product.getPrice());
		
		this.repo3.save(prod);
		return prod;
	}

	@Override
	public List<product_type> getTypes() {
		
			return this.repo.findAll();
	}

	@Override
	public List<product_category> getCategory(Long type) {
		// TODO Auto-generated method stub
		if (this.repo.findById(type).isEmpty()) {
			throw new genericException("Type doesn't exists");
		}
		return this.repo.findById(type).get().getProduct_category();
	}

	@Override
	public String deleteType(Long id) {
		if(this.repo3.findById(id).isEmpty()) {
			return "Type Doesn't exist";
		}
		this.repo.deleteById(id);
		return "Deleted Type";
	}

	@Override
	public String deleteCategory(Long id) {
		// TODO Auto-generated method stub
		if(this.repo2.findById(id).isEmpty()) {
			return "Category Doesn't exist";
		}
		this.repo2.deleteById(id);
		return "Category deleted";
	}

	@Override
	public String deleteProduct(Long id) {
		// TODO Auto-generated method stub
		if(this.repo3.findById(id).isEmpty()) {
			return "Product Doesn't exist";
		}
		this.repo3.deleteById(id);
		return "Product remved";
	}

	@Override
	public List<product_entity> getProduct(Long category) {
		// TODO Auto-generated method stub
		return this.repo2.findById(category).get().getProduct_entity();
		
	}

	@Override
	public String updateType(product_type prod_type) {
		if(this.repo.findById(prod_type.getId()).isEmpty()) {
			throw new genericException("Type doesn't exist");
		}
		product_type pt=this.repo.findById(prod_type.getId()).get();
		pt.setName(prod_type.getName()!=null?prod_type.getName():pt.getName());
		pt.setDesc(prod_type.getDesc()!=null?prod_type.getDesc():pt.getDesc());
		
		this.repo.save(pt);
		// TODO Auto-generated method stub
		return "Type Updated";
	}

	@Override
	public String updateType(product_category prod_category) {
		// TODO Auto-generated method stub
		if(this.repo2.findById(prod_category.getId()).isEmpty()) {
			throw new genericException("product doesn't exist");
		}
		product_category pc= this.repo2.getById(prod_category.getId());
		pc.setDesc(prod_category.getDesc()!=null?prod_category.getDesc():pc.getDesc());
		pc.setName(prod_category.getName()!=null?prod_category.getName():pc.getName());
		this.repo2.save(pc);
		return "Category Updated";
	}

	@Override
	public String updateProduct(product_entity prod) {
		// TODO Auto-generated method stub
		if(this.repo3.findById(prod.getId()).isEmpty()) {
			throw new genericException("product doesn't exist");
		}
		product_entity pe=this.repo3.getById(prod.getId());
		pe.setName(prod.getName());
		pe.setDesc(prod.getDesc());
		pe.setColor(prod.getColor());
		pe.setPrice(prod.getPrice());			
		this.repo3.save(pe);
		return "product updated";
	}
	
	
	
	
	
	
}
