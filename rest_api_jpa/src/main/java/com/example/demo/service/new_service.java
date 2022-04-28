package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.family;
import com.example.demo.repsitory.fam_repo;

@Service
public class new_service {
	@Autowired
	public fam_repo repo;
	
	List<family> allfamily=new ArrayList<>();

	
	public List<family> getFamily() {
		// TODO Auto-generated method stub
		
		return (List<family>) repo.findAll();
	}



	public List<family> addFamily(family family) {
		// TODO Auto-generated method stub
		repo.save(family);
		return (List<com.example.demo.entity.family>) repo.findAll();
	}



	



	public List<family> update(family family) {
		// TODO Auto-generated method stub
		if (repo.findById(family.getId()).isPresent()) {
			family existing= repo.findById(family.getId()).get();
			existing.setFname(family.getFname());
			existing.setLname(family.getLname());
		}
		repo.save(family);
		return (List<com.example.demo.entity.family>) repo.findAll();
	}



	public void delete(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		
		
		
	}



	public Optional<family> member(int id) {
		// TODO Auto-generated method stub
		
		return repo.findById(id);
	}
	
	
	
}
 