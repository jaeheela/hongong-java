package sec07.exam01_jlabel;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.border.EtchedBorder;

public class JLabelExample extends JFrame {
	private JLabel jLabel1, jLabel2, jLabel3, jLabel4;

	//메인 윈도우 설정
	public JLabelExample() {
		this.setTitle("JLabelExample");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new GridLayout(4, 1));

		this.getContentPane().add(getJLabel1());
		this.getContentPane().add(getJLabel2());
		this.getContentPane().add(getJLabel3());
		this.getContentPane().add(getJLabel4());
		this.setSize(200, 300);
	}

	//JLabel 생성: 텍스트 좌측 정렬, EtchedBorder 적용
	public JLabel getJLabel1() {
		if (jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("JLabel1");
			jLabel1.setHorizontalAlignment(JLabel.LEFT);
			jLabel1.setBorder(new EtchedBorder());
		}
		return jLabel1;
	}

	//JLabel 생성: 이미지 추가, 내용물 중앙 정렬
	public JLabel getJLabel2() {
		if (jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("JLabel2");
			jLabel2.setIcon(new ImageIcon(getClass().getResource("user.gif")));
			jLabel2.setHorizontalAlignment(JLabel.CENTER);
			jLabel2.setBorder(new EtchedBorder());
		}
		return jLabel2;
	}

	//JLabel 생성: 이미지 왼쪽에 텍스트가 오도록 설정
	public JLabel getJLabel3() {
		if (jLabel3 == null) {
			jLabel3 = new JLabel();
			jLabel3.setText("JLabel3");
			jLabel3.setIcon(new ImageIcon(getClass().getResource("user.gif")));
			jLabel3.setHorizontalAlignment(JLabel.CENTER);
			jLabel3.setHorizontalTextPosition(JLabel.LEFT);
			jLabel3.setBorder(new EtchedBorder());
		}
		return jLabel3;
	}

	//JLabel 생성: 이미지와 텍스트 사이의 간격 설정
	public JLabel getJLabel4() {
		if (jLabel4 == null) {
			jLabel4 = new JLabel();
			jLabel4.setText("JLabel4");
			jLabel4.setIcon(new ImageIcon(getClass().getResource("user.gif")));
			jLabel4.setHorizontalAlignment(JLabel.CENTER);
			jLabel4.setIconTextGap(20);
			jLabel4.setBorder(new EtchedBorder());
		}
		return jLabel4;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JLabelExample jFrame = new JLabelExample();
				jFrame.setVisible(true);
			}
		});
	}
}
