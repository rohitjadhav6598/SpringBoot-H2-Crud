package com.H2.Crud.H2Crud.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.H2.Crud.H2Crud.Repository.StudentRepository;
import com.H2.Crud.H2Crud.Services.H2CrudService;
import com.H2.Crud.H2Crud.models.Student;

@RestController
public class H2CrudController {
	
	@Autowired
	StudentRepository studentRepository;
	
	
	@GetMapping("/getstudents")
	public ResponseEntity<List<Student>> getAllStudents(@RequestParam(required = false) String name){
		try {
			List<Student> students = new ArrayList<>();
			if(name==null)
				studentRepository.findAll().forEach(students::add);
			else
				studentRepository.findByNameContaining(name).forEach(students::add);
			if(students.isEmpty()) return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
			return new ResponseEntity<>(students,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/student")
	public ResponseEntity<Student> addStudent(@RequestBody Student student){
		try {
			Student s = studentRepository.save(new Student(student.getName(),student.getStandard()));
			return new ResponseEntity<>(s,HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
