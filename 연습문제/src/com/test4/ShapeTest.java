package com.test4;
import java.util.ArrayList;

public class ShapeTest {

	public static void main(String[] args) {
		
		ArrayList<Shape> list = new ArrayList<Shape>();
		list.add(new Rectangle(4, 7, 5));
		list.add(new Rectangle(5, 4, 6));
		list.add(new Circle(6, 6, 7));
		list.add(new Circle(7, 8, 3));
		
		for(Shape s : list) {
			System.out.println(s);
		}
		
		for(Shape s : list) {
			((Movable)s).move(10,10);
		}
		
		for(Shape s : list) {
			System.out.println(s);
		}
	}
}
