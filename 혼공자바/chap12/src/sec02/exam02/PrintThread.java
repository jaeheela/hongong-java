package sec02.exam02;

public class PrintThread extends Thread {
	private boolean stop;
	
	public void setStop(boolean stop) {
	  this.stop = stop;
	}
	
	public void run() {	
		while(!stop) {
			System.out.println("���� ��");
		}	
		System.out.println("�ڿ� ����");
		System.out.println("���� ����");
	}
}

