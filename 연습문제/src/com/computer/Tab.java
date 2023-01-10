package com.computer;

public class Tab extends Computer implements Graphic {

	public Tab() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Tab(String name, int cpu, int memory, int battery) {
		super(name, cpu, memory, battery);
		// TODO Auto-generated constructor stub
	}


	@Override
	public double rendering(int size) {
		return (double)size / (getCpu() * getMemory()) * 30;
	}

	@Override
	public void operate(int time) {
		// 입력으로 들어온 시간 10 당 1씩 배터리가 감소.
		int result = time / 5;
		// 프로그램에서 연산(+,-,*,/)은 일단 같은 데이터 타입끼리 발생.
		setBattery(getBattery() - result);  
		
	}

}
