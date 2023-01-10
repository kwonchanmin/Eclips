package planetest;

public class PlaneTest {

	public static void main(String[] args) {
		Plane air = new Airplane("L747", 1000);
		Plane cargo = new CargoPlane("C40", 1000);
		
		System.out.println(air);
		System.out.println(cargo);
		
		air.flight(100);
		cargo.flight(100);
		
		System.out.println(air);
		System.out.println(cargo);
		
		air.refuel(200);
		cargo.refuel(200);
		
		System.out.println(air);
		System.out.println(cargo);
	}
}
