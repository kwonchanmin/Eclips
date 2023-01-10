package com.test5;

public abstract class Employee {

	// constructor
	public Employee() {
	}
	
	
	public Employee(String name, int number, String department, int salary) {
		super();
		this.name = name;
		this.number = number;
		this.department = department;
		this.salary = salary;
	}


	// field
	private String name;
	private int number;
	private String department;
	private int salary;
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public abstract double tax(); 
	
	@Override
	public String toString() {
		
		return name + "   "
				+ department + "   "
				+ salary;
	}
}
