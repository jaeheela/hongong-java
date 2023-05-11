package sec03.exam03_jframe;

import java.awt.GraphicsEnvironment;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class JFrameExample  extends JFrame {
	public JFrameExample() {
		//JWindow의 크기
		this.setSize(600, 500);
		
		//제목 표시줄 내용
		this.setIconImage(new ImageIcon(getClass().getResource("icon.png")).getImage());
		this.setTitle("메인창");
		
		//종료 버튼의 기본 기능
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
		//JWindow를 화면 중앙으로 띄우기
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Point centerPoint = ge.getCenterPoint();	
		int leftTopX = centerPoint.x - this.getWidth()/2;
		int leftTopY = centerPoint.y - this.getHeight()/2;
		this.setLocation(leftTopX, leftTopY);
	}
	
	public static void main(String[] args) {
	    SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	        	JFrameExample jFrame = new JFrameExample();
	        	jFrame.setVisible(true);
	        }
	    });
	}		
}
