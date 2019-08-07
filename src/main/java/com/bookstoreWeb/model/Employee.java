package com.bookstoreWeb.model;

import java.util.List;

public class Employee {

	private String designation;
	 
	private String department;
 
	private List<String> hobbies;
 
	public String getDesignation() {
		return designation;
	}
 
	public void setDesignation(String designation) {
		this.designation = designation;
	}
 
	public String getDepartment() {
		return department;
	}
 
	public void setDepartment(String department) {
		this.department = department;
	}
 
	public List<String> getHobbies() {
		return hobbies;
	}
 
	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}
}
