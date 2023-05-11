package sec14.exam06_image;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ImageExample extends JFrame {
	//메인 윈도우 설정
	public ImageExample() {
		setTitle("이미지 그리기");
		getContentPane().add(new MyCanvas(), BorderLayout.CENTER);
		add(new MyCanvas(), BorderLayout.CENTER);
		setSize(500,350);
	}

	//Canvas 클래스 선언
	public class MyCanvas extends Canvas {
		private Image imgSun, imgMoon;;		
		
		public MyCanvas() {
			//배경색을 흰색으로 변경
			setBackground(Color.WHITE);
			
			//이미지를 로딩해서 읽고, Image 객체 얻기
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			imgSun = toolkit.getImage(getClass().getResource("sun.gif"));
			imgMoon = new ImageIcon(getClass().getResource("moon.gif")).getImage();
		}		
		
		public void paint(Graphics g) {
			//이미지 드로잉
			g.drawImage(imgSun, 10, 10, this);
			g.drawImage(imgMoon, 300, 20, this);
		}
	}
	
	public static void main(String[] args) {
	    SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	        	ImageExample jFrame = new ImageExample();
	        	jFrame.setVisible(true);
	        }
	    });
	}
}


