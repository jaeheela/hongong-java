package sec02.verify.exam01;

public class AnonymousExample {
	public static void main(String[] args) {
		Anonymous anony = new Anonymous();
		//�͸� ��ü �ʵ� ���
		anony.field.start();
		//�͸� ��ü ���ú��� ���
		anony.method1();
		//�͸� ��ü �Ű��� ���
		anony.method2(
			new Worker() {
				@Override
				public void start() {
					System.out.println("�׽�Ʈ�� �մϴ�.");
				}
			}
		);
	}
}
