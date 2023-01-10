package com.test5;

public class Sales extends Employee implements Bonus {

	public Sales() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Sales(String name, int number, String department, int salary) {
		super(name, number, department, salary);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void incentive(int pay) {
		setSalary((int)((pay * 1.2) + getSalary()));		
	}

	@Override
	public double tax() {		
		return getSalary() * 0.13;
	}

}
