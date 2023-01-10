package com.test4;

public abstract class Shape {

	// constructor
	public Shape() {
		// TODO Auto-generated constructor stub
	}

	public Shape(Point point) {
		super();
		this.point = point;
	}


	// field
	protected Point point;


	// method
	
	// getter & setter
	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}
	
	public abstract double getArea();
	public abstract double getCircumference();
	
	
}
