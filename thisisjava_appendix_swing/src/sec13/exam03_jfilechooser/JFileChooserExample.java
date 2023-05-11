package sec13.exam03_jfilechooser;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

public class JFileChooserExample extends JFrame {
	private JButton btnFileOpen, btnFileSave;

	//메인 윈도우 설정
	public JFileChooserExample() {
		this.setTitle("JFileChooserExample");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new GridLayout(2, 1));
		this.getContentPane().add(getBtnFileOpen());
		this.getContentPane().add(getBtnFileSave());
		this.setSize(150, 100);
	}

	//열기 버튼 생성
	public JButton getBtnFileOpen() {
		if (btnFileOpen == null) {
			btnFileOpen = new JButton();
			btnFileOpen.setText("File Open");
			btnFileOpen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//파일 열기 다이얼로그 보여주기
					JFileChooser jFileChooser = new JFileChooser();
					jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter(
							"그림 파일(*.jpg, *.gif, *.bmp)", "jpg", "gif", "bmp"));
					jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter(
							"텍스트 파일(*.txt)", "txt"));
					int option = jFileChooser.showOpenDialog(JFileChooserExample.this);
					//어떤 버튼을 클릭했는지 확인하기
					if (option == JFileChooser.APPROVE_OPTION) {
						File file = jFileChooser.getSelectedFile();
						System.out.println("열어야 할 파일 절대경로: " + file.getAbsolutePath());
						System.out.println("열어야 할 파일 이름: " + file.getName());
					} else if (option == JFileChooser.CANCEL_OPTION) {
						System.out.println("취소 또는 닫기를 눌렀군요");
					}
				}
			});
		}
		return btnFileOpen;
	}

	//저장 버튼 생성
	public JButton getBtnFileSave() {
		if (btnFileSave == null) {
			btnFileSave = new JButton();
			btnFileSave.setText("File Save");
			btnFileSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//파일 저장 다이얼로그 보여주기
					JFileChooser jFileChooser = new JFileChooser();
					jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter(
							"그림파일(*.jpg, *.gif, *.bmp)", "jpg", "gif", "bmp"));
					jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter(
							"텍스트 파일(*.txt)", "txt"));
					int option = jFileChooser.showSaveDialog(JFileChooserExample.this);
					//어떤 버튼을 클릭했는지 확인하기
					if (option == JFileChooser.APPROVE_OPTION) {
						File file = jFileChooser.getSelectedFile();
						System.out.println("저장할 파일: " + file.getAbsolutePath());
					} else if (option == JFileChooser.CANCEL_OPTION) {
						System.out.println("취소 또는 닫기를 눌렀군요");
					}
				}
			});
		}
		return btnFileSave;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFileChooserExample jFrame = new JFileChooserExample();
				jFrame.setVisible(true);
			}
		});
	}
}

