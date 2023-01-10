package com.uni;

public class Student extends Human {

	// constructor
	public Student() {
	}
	
	public Student(String name, int age, int height, int weight, String number, String major) {
		super(name, age, height, weight);
		this.number = number;
		this.major = major;
	}
	
	// field
	private String number;
	private String major;
	
	// getter & setter
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}

	// method
	@Override
	public String printInformation() {
		// 학생의 정보를 출력하는거예요..
		// Human의 정보 + 학생 특유의 정보
		return super.printInformation() + " " + number + " " + major;
	}	
	
	
	
	
}
