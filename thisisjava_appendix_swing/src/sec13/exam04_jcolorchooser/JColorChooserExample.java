package sec13.exam04_jcolorchooser;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class JColorChooserExample extends JFrame {
	private JButton btnColor;

	//메인 윈도우 설정
	public JColorChooserExample() {
		this.setTitle("JColorChooserExample");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new GridLayout(1, 1));
		this.getContentPane().add(getBtnColor());
		this.setSize(150, 60);
	}

	//버튼 생성
	public JButton getBtnColor() {
		if (btnColor == null) {
			btnColor = new JButton();
			btnColor.setText("JColorChooser");
			btnColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//색상 다이얼로그 보여주기
					Color color = JColorChooser.showDialog(
							JColorChooserExample.this, "색상 선택", Color.BLUE);
					//버튼의 배경색을 변경
					btnColor.setBackground(color);
				}
			});
		}
		return btnColor;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JColorChooserExample jFrame = new JColorChooserExample();
				jFrame.setVisible(true);
			}
		});
	}
}

