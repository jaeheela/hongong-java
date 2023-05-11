package sec14.exam04_shape;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ShapeExample extends JFrame {
	//메인 윈도우 설정
	public ShapeExample() {
		setTitle("도형 그리기");
		getContentPane().add(new MyCanvas(), BorderLayout.CENTER);
		setSize(400,300);
	}

	//Canvas 클래스 선언
	public class MyCanvas extends Canvas {
		public void paint(Graphics g) {
			//원 그리기
			g.drawOval(50,50, 50,50);
			g.setColor(Color.GREEN);
			g.fillOval(50,100, 50,50);

			//선 그리기
			g.setColor(Color.RED);
			g.drawLine(50,100, 100,150);
			g.drawLine(150,50, 50,150);

			//사각형 그리기
			g.setColor(Color.BLUE);
			g.drawRoundRect(200, 50, 120, 80, 30, 30);
			g.setColor(Color.YELLOW);
			g.fillRoundRect(250, 100, 120, 80, 30, 30);
			
			//다각형 그리기
			g.setColor(Color.ORANGE);
			g.fillPolygon(new int[]{50, 100, 150, 200}, new int[]{250, 200, 200, 250}, 4);
			
			//호 그리기
			g.setColor(Color.cyan);
			g.fillArc(250, 200, 100, 100, 45, 120);
		}
	}	
	
	public static void main(String[] args) {
	    SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	        	ShapeExample jFrame = new ShapeExample();
	        	jFrame.setVisible(true);
	        }
	    });
	}
}

