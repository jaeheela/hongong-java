package sec14.exam05_antialiasing;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class AntiAliasingExample extends JFrame {
	//메인 윈도우 설정
	public AntiAliasingExample() {
		setTitle("안티알리아싱");
		getContentPane().add(new MyCanvas(), BorderLayout.CENTER);
		setSize(200,350);
	}

	//Canvas 클래스 선언
	public class MyCanvas extends Canvas {
		public void paint(Graphics g) {
			//안티알리어싱을 적용하지 않은 원
			g.fillOval(50, 50, 100, 100);
			
			//안티알리어싱을 적용한 원
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g.fillOval(50, 200, 100, 100);
		}
	}	
	
	public static void main(String[] args) {
	    SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	        	AntiAliasingExample jFrame = new AntiAliasingExample();
	        	jFrame.setVisible(true);
	        }
	    });
	}
}

