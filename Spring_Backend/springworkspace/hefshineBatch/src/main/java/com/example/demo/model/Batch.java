package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity@Data@AllArgsConstructor@NoArgsConstructor@ToString
public class Batch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String batchName;
	int totalStudent;
	String trainerName;
	int driveCount;
	
		
	

}
