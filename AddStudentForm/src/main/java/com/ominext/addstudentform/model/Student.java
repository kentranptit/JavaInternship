package com.ominext.addstudentform.model;

public class Student {

	private int id;
	private String name;
	private int age;
	private String gender;
	private String address;
	private String phone;
	private String email;
	private String[] favorites;
	private String major;
	
	public Student() {
		super();
	}

	public Student(int id, String name, int age, String gender, String address, String phone, String email,
			String[] favorites, String major) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.favorites = favorites;
		this.major = major;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String[] getFavorites() {
		return favorites;
	}

	public void setFavorites(String[] favorites) {
		this.favorites = favorites;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
}
