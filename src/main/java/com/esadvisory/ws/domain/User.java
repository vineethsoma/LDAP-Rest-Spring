package com.esadvisory.ws.domain;

public class User {
	
	
	 	private String fullName;

	   private String lastName;

	   private String employeeID ; 
	   private String newtworkID ; 
	   public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getNewtworkID() {
		return newtworkID;
	}

	public void setNewtworkID(String newtworkID) {
		this.newtworkID = newtworkID;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String company;

	   private String phone;
	   
	   private String password ;
	   
	   
	 public String toString(){
		 
		 return this.fullName + this.lastName + this.employeeID + this.company ; 
		 
	 }
}
