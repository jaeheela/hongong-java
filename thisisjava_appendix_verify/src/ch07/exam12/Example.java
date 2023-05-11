package ch07.exam12;

public class Example {
	//메소드 선언
	public static void action(A a) {
		a.method1();
		if( a instanceof C c ) {
		      c.method2();
		} 
	}
	
	public static void main(String[] args) {
		//메소드 호출
		action(new A());
		action(new B());
		action(new C());
	}
}
