package com.test5;

public class Secretary extends Employee implements Bonus {

	public Secretary() {
		// TODO Auto-generated constructor stub
	}
	
	public Secretary(String name, int number, String department, int salary) {
		super(name, number, department, salary);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void incentive(int pay) {
		setSalary((int)((pay * 0.8) + getSalary()));
	}

	@Override
	public double tax() {
		return getSalary() * 0.1;
	}

}
