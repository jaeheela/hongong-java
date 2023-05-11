package sec05.exam01_windowadpater;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ClosableExample2 extends JFrame {
	private JButton btnClose;
	
	//메인 윈도우 설정
	public ClosableExample2() {
		this.setTitle("CloseExample");
		this.setSize(300, 100);		
		
		this.setLayout(new FlowLayout());
		this.getContentPane().add(getBtnClose());
		
		//익명 WindowListener 객체 추가
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	private JButton getBtnClose() {
		if(btnClose == null) {
			btnClose = new JButton();
			btnClose.setText("닫기");
			
			//익명 ActionListener 객체 추가
			btnClose.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}		
		return btnClose;
	}
	
	public static void main(String[] args) {
	    SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	        	ClosableExample2 jFrame = new ClosableExample2();
	        	jFrame.setVisible(true);
	        }
	    });
	}	
}
