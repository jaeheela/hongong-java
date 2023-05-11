package sec06.exam03_jradiobutton;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

public class JRadioButtonExample extends JFrame {
	private JPanel radioPanel;
	private JRadioButton rbBird;
	private JRadioButton rbCat;
	private JLabel lblPicture;

	// 메인 윈도우 설정
	public JRadioButtonExample() {
		setTitle("JRadioButtonExample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(getRadioPanel(), BorderLayout.WEST);
		this.getContentPane().add(getLblPicture(), BorderLayout.CENTER);
		pack();
	}

	// JRadioButton들이 배치된 JPanel 생성
	public JPanel getRadioPanel() {
		if (radioPanel == null) {
			radioPanel = new JPanel();

			radioPanel.setLayout(new GridLayout(2, 1));
			radioPanel.add(getRbBird());
			radioPanel.add(getRbCat());

			// 배타적 선택을 위해 ButtonGroup에 두 개의 JRadioButton 추가
			ButtonGroup group = new ButtonGroup();
			group.add(getRbBird());
			group.add(getRbCat());
		}
		return radioPanel;
	}

	// JRadioButton 생성
	public JRadioButton getRbBird() {
		if (rbBird == null) {
			rbBird = new JRadioButton();
			rbBird.setText("Bird");
			rbBird.setSelected(true);  //기본적으로 선택되도록 설정
			rbBird.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getLblPicture().setIcon(new ImageIcon(getClass().getResource("Bird.gif")));
				}
			});
		}
		return rbBird;
	}

	// JRadioButton 생성
	public JRadioButton getRbCat() {
		if (rbCat == null) {
			rbCat = new JRadioButton();
			rbCat.setText("Cat");
			rbCat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getLblPicture().setIcon(new ImageIcon(getClass().getResource("Cat.gif")));
				}
			});
		}
		return rbCat;
	}

	// 이미지를 보여줄 JLabel 생성
	public JLabel getLblPicture() {
		if (lblPicture == null) {
			lblPicture = new JLabel();
			lblPicture.setIcon(new ImageIcon(getClass().getResource("Bird.gif")));
		}
		return lblPicture;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JRadioButtonExample jFrame = new JRadioButtonExample();
				jFrame.setVisible(true);
			}
		});
	}
}

