package com.example.demo.controller;

import java.rmi.StubNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Admin;
import com.example.demo.model.Batch;
import com.example.demo.model.Student;
import com.example.demo.repository.AdminRepo;
import com.example.demo.repository.BatchRepo;
import com.example.demo.repository.StudentRepo;

import jakarta.websocket.server.PathParam;

@CrossOrigin
@RestController
public class MyController {
	
	@Autowired
	BatchRepo batchrepo;
	
	@Autowired
	AdminRepo adminrepo;
	
	@Autowired
	StudentRepo studentrepo;

	//List<Batch> batches=new ArrayList<>();
	
	@RequestMapping("login{username}and{password}")
	public int login(@PathVariable String username,@PathVariable String password)
	{
		List<Admin> list = adminrepo.findAll();
		for(Admin admin:list)
		{
			if(admin.getUsername().equals(username))
			{
				if(admin.getPassword().equals(password))
				{
					if(admin.getActive()==1)
					{
						return 3;//login done
					}else
					{
						return 2;//user not active
					}
					
				}
				else
				{
					return 1;//password not match
				}
				
			}
		}
		return 0;//username not match
	}
	
	@RequestMapping("register")
	public boolean register(@RequestBody Admin admin)
	{
		try {
			
			admin.setActive(0);
			adminrepo.save(admin);
			return true;
			
		} catch (Exception e) {

		e.printStackTrace();
		return false;
		}
	}
	
	@RequestMapping("load")
	public List<Batch> loadBatch()
	{
		
		List<Batch> list = batchrepo.findAll();
		return list;
				
	}
	
	@RequestMapping("add")
	public Batch addBatch(@RequestBody Batch batch)
	{
		
		try {
			System.out.println("in add spring");
			Batch save = batchrepo.save(batch);
			return save;
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		
		}
		
	}
	
	@RequestMapping("delete{id}")
	public boolean deleteBatch(@PathVariable int id)
	{
		try {
			
			batchrepo.deleteById(id);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
		
			return false;
		
		}
		
	}
	
	@RequestMapping("registerStudent")
	public boolean registerStudent(@RequestBody Student student)
	{
		try {
			
			student.setStudentActive(0);
			studentrepo.save(student);
			return true;
			
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		
		}
	}
	
	@RequestMapping("loginStudent{username}and{password}")
	public int loginStudent(@PathVariable String username,@PathVariable String password)
	{
		List<Student> list = studentrepo.findAll();
		for(Student student:list)
		{
			if(student.getStudentUsername().equals(username))
			{
				if(student.getStudentPassword().equals(password))
				{
					if(student.getStudentActive()==1)
					{
						return 3;//login done
					}else
					{
						return 2;//user not active
					}
					
				}
				else
				{
					return 1;//password not match
				}
				
			}
		}
		return 0;//username not match
	}
	
}



	

