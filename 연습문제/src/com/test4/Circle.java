package com.test4;

public class Circle extends Shape implements Movable {

	// 생성자
	public Circle() {
		// TODO Auto-generated constructor stub
	}
	
	public Circle(int radius, int x, int y) {
		super(new Point(x,y));
		this.radius = radius;
	}
	
	// field
	private int radius;
	
	@Override
	public void move(int x, int y) {
		// x와 y의 좌표값을 변경하는 거예요!
		Point p = getPoint();
		p.setX(p.getX() + x + 1);
		p.setY(p.getY() + y + 1);
		setPoint(p);
	}

	@Override
	public double getArea() {
		return Math.round(Math.pow(radius, 2) * Math.PI); 
	}

	@Override
	public double getCircumference() {
		return Math.round(2 * radius * Math.PI);
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public String toString() {
		
		return this.getClass().getSimpleName() + "   "
				+ radius + "   "
				+ getPoint().getX() + "   "
				+ getPoint().getY() + "   "
				+ getArea() + "   "
				+ getCircumference();
	}

	
	
}
