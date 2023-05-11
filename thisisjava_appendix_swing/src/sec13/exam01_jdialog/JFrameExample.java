package sec13.exam01_jdialog;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class JFrameExample extends JFrame {
	private JButton btnOpenDialog;

	//메인 윈도우 설정
	public JFrameExample() {
		this.setTitle("JFrame");
		this.setSize(500, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(getBtnOpenDialog(), BorderLayout.SOUTH);
	}

	//남쪽 버튼 생성
	private JButton getBtnOpenDialog() {
		if (btnOpenDialog == null) {
			btnOpenDialog = new JButton();
			btnOpenDialog.setText("다이얼로그 띄우기");
			btnOpenDialog.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					//다이얼로그 띄우기
					JDialogExample jDialog = new JDialogExample(JFrameExample.this);
					jDialog.setVisible(true);
				}
			});
		}
		return btnOpenDialog;
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
