package sec15.exam05;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class PieGraph extends JFrame {
	private int vc = 20;
	private int java = 40;
	private int cshap = 25;
	private int vb = 15;
	
	public PieGraph() {
		this.setTitle("파이 그래프");
		this.getContentPane().add(new MyCanvas(), BorderLayout.CENTER);
		this.setSize(400, 350);
	}	
	
	public class MyCanvas extends Canvas {
		public void paint(Graphics g) {
			//이전 내용을 지우는 코드
			g.clearRect(0, 0, getWidth(), getHeight());
			//안티알리아싱 활성화
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			//각도 계산
			int total = vc + java + cshap + vb;
			int arc1 =  360 * vc / total;
			int arc2 =  360 * java / total;
			int arc3 =  360 * cshap / total;
			int arc4 =  360 * vb / total;
			//호 그리기
			g.setColor(Color.YELLOW);
			g.fillArc(50, 50, 200, 200, 0, arc1);
			g.setColor(Color.RED);
			g.fillArc(45, 45, 200, 200, arc1, arc2);
			g.setColor(Color.BLUE);
			g.fillArc(50, 50, 200, 200, arc1 + arc2, arc3);
			g.setColor(Color.GREEN);
			g.fillArc(50, 50, 200, 200, arc1 + arc2 + arc3, arc4);
			//범례 그리기
			g.setColor(Color.YELLOW);
			g.fillRect(280, 140, 10, 10);
			g.setColor(Color.BLACK);
			g.drawString("VC", 300, 150);		
			g.setColor(Color.RED);
			g.fillRect(280, 160, 10, 10);
			g.setColor(Color.BLACK);
			g.drawString("JAVA", 300, 170);		
			g.setColor(Color.BLUE);
			g.fillRect(280, 180, 10, 10);
			g.setColor(Color.BLACK);
			g.drawString("VC#", 300, 190);		
			g.setColor(Color.GREEN);
			g.fillRect(280, 200, 10, 10);
			g.setColor(Color.BLACK);
			g.drawString("VB", 300, 210);
		}
	}
	
	public static void main(String[] args) {
	    SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	        	PieGraph jFrame = new PieGraph();
	        	jFrame.setVisible(true);
	        }
	    });
	}	
}
