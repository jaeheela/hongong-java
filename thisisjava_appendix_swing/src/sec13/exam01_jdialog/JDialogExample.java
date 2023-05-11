package sec13.exam01_jdialog;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class JDialogExample extends JDialog {
	private JButton btnClose;

	//다이얼로그 설정
	public JDialogExample(JFrame owner) {
		super(owner);
		this.setTitle("JDialogExample");
		this.setSize(300, 200);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setModal(true);
		this.setLocation(
			owner.getLocationOnScreen().x + (owner.getWidth() - this.getWidth()) / 2,
			owner.getLocationOnScreen().y + (owner.getHeight() - this.getHeight()) / 2
		);
		this.getContentPane().add(getBtnClose(), BorderLayout.SOUTH);
	}

	//남쪽 버튼 생성
	public JButton getBtnClose() {
		if (btnClose == null) {
			btnClose = new JButton();
			btnClose.setText("닫기");
			btnClose.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JDialogExample.this.dispose();
				}
			});
		}
		return btnClose;
	}
}

