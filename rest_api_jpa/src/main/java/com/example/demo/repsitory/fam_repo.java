package com.example.demo.repsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.family;

@Repository
public interface fam_repo extends CrudRepository<family,Integer>{
	
}
