package ch03.exam05;

public class Example {
	public static void main(String[] args) {
		int lengthTop = 5;
		int lengthBottom = 10;
		int height = 7;
		
		double area = ( (lengthTop + lengthBottom) * height / 2.0 );
		System.out.println(area);		
		
		area = ( (lengthTop + lengthBottom) * height * 1.0 / 2 );
		System.out.println(area);
		
		area = ( (double)(lengthTop + lengthBottom) * height / 2 );
		System.out.println(area);
		
		area = ( (double)((lengthTop + lengthBottom) * height / 2) );
		System.out.println(area);
	}
}


