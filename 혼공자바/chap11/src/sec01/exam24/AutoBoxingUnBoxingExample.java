package sec01.exam24;

public class AutoBoxingUnBoxingExample {
	public static void main(String[] args) {
		//�ڵ� Boxing
		Integer obj = 100;
		System.out.println("value: " + obj.intValue());
	
		//���Խ� �ڵ� Unboxing
		int value = obj;  	
		System.out.println("value: " + value);
		
		//����� �ڵ� Unboxing
		int result = obj + 100;
		System.out.println("result: " + result);
	}
}

