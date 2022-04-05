package com.H2.Crud.H2Crud.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.H2.Crud.H2Crud.Repository.StudentRepository;
import com.H2.Crud.H2Crud.models.Student;

public class H2CrudService {
	
	@Autowired
	StudentRepository studentRepository;
	
	public List<Student> getAllStudents(String name){
			List<Student> students = new ArrayList<>();
			if(name==null)
				studentRepository.findAll().forEach(students::add);
			else
				studentRepository.findByNameContaining(name).forEach(students::add);
			return students;
			
	}
}
