package com.computer;

public class ComputerTest {

	public static void main(String[] args) {
		
		Computer[] arrays = new Computer[4];
		// int[]     k    = new    int[4];
		// 아하.. arryas안에는 Computer라는 클래스 타입의 객체가 들어와요!
		// Labtop과 Tab은 둘 다 Computer의 subclass예요!
		// 따라서 IS-A 관계에 의해 .. Labtop과 Tab의 instance는 배열에 저장이 가능!
		arrays[0] = new Laptop("Laptop01", 2, 1024, 2000);
		arrays[1] = new Laptop("Laptop02", 3, 2048, 2300);
		arrays[2] = new Tab("Tab01", 2, 1024, 1200);
		arrays[3] = new Tab("Tab02", 3, 2048, 1300);
		
		// 기본정보 출력
		for(Computer tmp : arrays) {
			System.out.println(tmp);
		}
		
		// 컴퓨터 사용
		for(Computer tmp : arrays) {
			tmp.operate(55);  // 동적 바인딩이 발생해요!
			                  // overriding된 method가 호출되요!
			if(tmp instanceof Laptop) {
				System.out.println(((Laptop)tmp).rendering(100));
				
			} else {
				System.out.println(((Tab)tmp).rendering(100));				
			}
			
		}
		
	}
}
