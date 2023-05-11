package sec04.exam02_flowlayout;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class FlowLayoutExample  extends JFrame {
	private JButton btnOk;
	private JButton btnCancel;
	
	//메인 윈도우 설정
	public FlowLayoutExample() {
		this.setTitle("FlowLayoutExample");
		this.setSize(300, 100);		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//FlowLayout으로 변경하고 두 개의 버튼 추가
		this.setLayout(new FlowLayout());
		this.getContentPane().add(getBtnOk());
		this.getContentPane().add(getBtnCancel());
	}
	
	//Ok 버튼 생성
	private JButton getBtnOk() {
		if(btnOk == null) {
			btnOk = new JButton();
			btnOk.setText("확인");
		}
		return btnOk;
	}

	//Cancel 버튼 생성
	private JButton getBtnCancel() {
		if(btnCancel == null) {
			btnCancel = new JButton();
			btnCancel.setText("취소");
		}		
		return btnCancel;
	}
	
	public static void main(String[] args) {
	    SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	        	FlowLayoutExample jFrame = new FlowLayoutExample();
	        	jFrame.setVisible(true);
	        }
	    });
	}
}
