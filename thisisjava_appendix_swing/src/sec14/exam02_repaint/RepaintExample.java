package sec14.exam02_repaint;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class RepaintExample extends JFrame {
	//메인 윈도우 설정
	public RepaintExample() {
		setTitle("재 드로잉");
		
		//Canvas를 중앙에 배치
		getContentPane().add(new MyCanvas(), BorderLayout.CENTER);
		
		setSize(500, 400);
	}	

	//Canvas 클래스 선언
	public class MyCanvas extends Canvas implements MouseMotionListener {
		private int x;
		private int y;
		
		public MyCanvas() {
			//MouseMotionListener 추가
			addMouseMotionListener(this);
		}
		
		//Canvas의 update() 재정의
		@Override
		public void update(Graphics g) {
			paint(g);
		}
		
		//Canvas의 paint() 재정의
		@Override
		public void paint(Graphics g) {
			g.drawString("*", x, y);
		}		
		
		//MouseMotionListener의 mouseDragged() 재정의
		//마우스 버튼을 누르고 움직일 때 호출
		@Override
		public void mouseDragged(MouseEvent e) {
			x = e.getX();
			y = e.getY();
			
			//Canvas의 repaint() 호출
			repaint();		
		}
		
		//MouseMotionListener의 mouseMoved() 재정의
		//마우스 버튼을 누르지 않고 움직일 때 호출
		@Override
		public void mouseMoved(MouseEvent e) {
			System.out.println("aaa");
		}
	}
	
	public static void main(String[] args) {
	    SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	        	RepaintExample jFrame = new RepaintExample();
	        	jFrame.setVisible(true);
	        }
	    });
	}
}


