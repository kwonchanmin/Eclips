package planetest;

public class Airplane extends Plane {

	public Airplane() {
	
	}
	
	public Airplane(String planeName, int fuelSize) {
		super(planeName, fuelSize);
	}
	
	@Override
	public void flight(int distance) {
		// 연료량은 운행거리 * 3 만큼 줄이면되요!
		setFuelSize(getFuelSize() - (distance*3));
	}
}

class CargoPlane extends Plane {

	public CargoPlane() {
		super();
	}

	public CargoPlane(String planeName, int fuelSize) {
		super(planeName, fuelSize);
	}

	@Override
	public void flight(int distance) {
		setFuelSize(getFuelSize() - (distance*5));
		
	}
}
