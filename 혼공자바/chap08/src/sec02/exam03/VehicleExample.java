package sec02.exam03;

public class VehicleExample {
	public static void main(String[] args) {
		Vehicle vehicle = new Bus();

		vehicle.run();
		//vehicle.checkFare(); (x)

		Bus bus = (Bus) vehicle;  //����Ÿ�Ժ�ȯ

		bus.run();
		bus.checkFare();
	}
}
