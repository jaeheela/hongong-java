package sec04.exam04_gridlayout;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class GridLayoutExample extends JFrame {
	private JButton[][] btn;
	
	//메인 윈도우 설정
	public GridLayoutExample() {
		setTitle("GridLayoutExample");
		setSize(300, 100);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//GridLayout으로 변경하고 버튼 추가
		setLayout(new GridLayout(2,3));
		for(int r = 0; r<2; r++) {
			for(int c=0; c<3; c++) {
				getContentPane().add(getBtn()[r][c]);
			}
		}
	}
	
	//버튼 배열 생성
	public JButton[][] getBtn() {
		if(btn == null) {
			btn = new JButton[2][3];
			for(int r = 0; r<2; r++) {
				for(int c=0; c<3; c++) {
					btn[r][c] = new JButton();
					btn[r][c].setText("["+r+"][" + c + "]");
				}
			}
		}		
		return btn;
	}
	
	public static void main(String[] args) {
	    SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	        	GridLayoutExample jFrame = new GridLayoutExample();
	        	jFrame.setVisible(true);
	        }
	    });
	}	
}
