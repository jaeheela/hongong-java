package sec01.exam03;

public class Computer extends Calculator {
	@Override
	double areaCircle(double r) {
	System.out.println("Computer °´Ã¼ÀÇ areaCircle() ½ÇÇà");
		return Math.PI * r * r;
	}
}


