package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Batch;

@Repository
public interface BatchRepo  extends JpaRepository<Batch, Integer>{

	
	
}
