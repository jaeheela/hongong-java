package sec15.exam04;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class BarGraph extends JFrame {
	private int korean = 75;
	private int english = 95;
	private int math = 60;

	public BarGraph() {
		this.setTitle("막대 그래프");
		this.getContentPane().add(new MyCanvas(), BorderLayout.CENTER);
		this.setSize(400, 350);
	}
	
	public class MyCanvas extends Canvas {
		public void paint(Graphics g) {
			//이전 내용을 지움
			g.clearRect(0, 0, getWidth(), getHeight());
	        //X축 그리기
	        g.drawLine(50, 250, 350, 250);  
	        g.drawString("국어", 100, 270); 
	        g.drawString("영어", 200, 270); 
	        g.drawString("수학", 300, 270); 
	        //Y축 그리기
	        g.drawLine(50, 40, 50, 250);
	        //눈금선 그리기
	        for (int cnt = 1; cnt < 11; cnt++) {
	            g.drawString(cnt * 10 + "", 25, 255 - 20 * cnt);    
	            g.drawLine(50, 250 - 20 * cnt, 350, 250 - 20 * cnt);
	        }
	        //막대 그래프 그리기
	        if (korean > 0) {
	        	 g.setColor(Color.RED);
	            g.fillRect(110, 250 - korean * 2, 10, korean * 2);
	        }
	        if (english > 0) {
	        	 g.setColor(Color.GREEN);
	             g.fillRect(210, 250 - english * 2, 10, english * 2);
	        }
	        if (math > 0) {
	        	 g.setColor(Color.BLUE);
	        	 g.fillRect(310, 250 - math * 2, 10, math * 2);
	        }
		}		
	}
	
	public static void main(String[] args) {
	    SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	        	BarGraph jFrame = new BarGraph();
	        	jFrame.setVisible(true);
	        }
	    });
	}	
}