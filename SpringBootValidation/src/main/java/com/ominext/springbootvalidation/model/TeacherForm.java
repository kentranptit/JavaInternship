package com.ominext.springbootvalidation.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TeacherForm {
	
	@NotNull
	@Size(min=2, max=30)
	private String name;
	
	@NotNull
	private String gender;
	
	@NotNull
	@Min(16)
	private int age;
	
	private double experience;
	
	@NotNull
	@Size(min=2, max=60)
	private String department;
	
	public TeacherForm() {
		super();
	}

	public TeacherForm(String name, String gender, int age, double experience, String department) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.experience = experience;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getExperience() {
		return experience;
	}

	public void setExperience(double experience) {
		this.experience = experience;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
}
