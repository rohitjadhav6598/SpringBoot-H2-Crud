package com.H2.Crud.H2Crud.models;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	@Column(name="name")
	private String name;

	@Column(name = "standard")
	private int standard;
	
	public Student() {
	}
	
	public Student(String name) {
		this.name = name;
	}

	public Student(String name, int standard) {
		this.name = name;
		this.standard = standard;
	}

	public int getStandard() {
		return standard;
	}

	public void setStandard(int standard) {
		this.standard = standard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return Id;
	}

	@Override
	public String toString() {
		return "Student [Id=" + Id + ", name=" + name + "]";
	}
	
}
