package com.H2.Crud.H2Crud.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.H2.Crud.H2Crud.models.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	List<Student> findById(long Id);
	List<Student> findByNameContaining(String name);
 
}
