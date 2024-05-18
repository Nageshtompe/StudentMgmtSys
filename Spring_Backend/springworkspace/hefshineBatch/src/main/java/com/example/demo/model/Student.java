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
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String firstName;
	String lastName;
	long mobileNumber;
	String emailId;
	int studentActive;
	String studentBatch;
	String studentUsername;
	String studentPassword;
	
//	firstName:String;
//    lastName:String;
//    mobileNumber:String;
//    emailId:String;
//    studentBatch:String;
//    studentUsername:String;
//    studentPassword:String;

}
