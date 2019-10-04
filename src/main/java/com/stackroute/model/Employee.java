package com.stackroute.model;

public class Employee {
	private int id;
	private String name;
	private String gender;
	private String designation;
	private String city;
	private long salary;
	
	public Employee(int id, String name, String gender, String designation, String city, long salary) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.designation = designation;
		this.city = city;
		this.salary = salary;
	}

	public Employee() {
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

}
