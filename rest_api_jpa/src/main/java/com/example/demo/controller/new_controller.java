package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.family;
import com.example.demo.service.new_service;

@RestController
public class new_controller {
	@Autowired
	public new_service service;
	
	@GetMapping("/")
	public ResponseEntity<List<family>> getFamily(){
		
			if (service.getFamily().isEmpty() ){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
			else {
		return new ResponseEntity<List<family>> (service.getFamily(), HttpStatus.OK) ;
			}
		}
	
	@PostMapping("/create")
	public List<family> addFamily(@RequestBody family family){			
		return service.addFamily(family);
	}
	
	@PutMapping("/update")
	public List<family> update(@RequestBody family family){
		return service.update(family);
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		service.delete(id);
		
		return "Memeber Deleted";
	}
	
	@GetMapping("/member/{id}")
	public Optional<family> member(@PathVariable("id") int id ) {
		
		return service.member(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
