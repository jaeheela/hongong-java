package sec13.exam02_joptionpane;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class JOptionPaneExample extends JFrame {
	private JButton btnMessage, btnConfirm;
	private JButton btnInput, btnOption;
	
	//메인 윈도우 설정
	public JOptionPaneExample() {
		this.setTitle("JOptionPaneExample");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new GridLayout(4,1));
		this.getContentPane().add(getBtnMessage());
		this.getContentPane().add(getBtnConfirm());
		this.getContentPane().add(getBtnInput());
		this.getContentPane().add(getBtnOption());
		this.setSize(500, 300);
	}
	
	//MessageDialog를 보여주는 버튼 생성
	public JButton getBtnMessage() {
		if(btnMessage == null) {
			btnMessage = new JButton();
			btnMessage.setText("MessageDialog");
			btnMessage.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//MessageDialog 보여줌
					JOptionPane.showMessageDialog(
							JOptionPaneExample.this, 
							"다이얼로그 텍스트 내용",
							"INFORMATION_MESSAGE",
							JOptionPane.INFORMATION_MESSAGE);
				}
			});
		}
		return btnMessage;
	}

	//ConfirmDialog를 보여주는 버튼 생성
	public JButton getBtnConfirm() {
		if(btnConfirm == null) {
			btnConfirm = new JButton();
			btnConfirm.setText("ConfirmDialog");
			btnConfirm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//ConfirmDialog을 보여줌
					int option = JOptionPane.showConfirmDialog(
							JOptionPaneExample.this, 
							"다이얼로그 텍스트 내용", 
							"OK_CANCEL_OPTION", 
							JOptionPane.OK_CANCEL_OPTION, 
							JOptionPane.PLAIN_MESSAGE,
							null);
					//클릭된 버튼 확인하기
					if(option == JOptionPane.OK_OPTION) {
						System.out.println("확인 버튼을 눌렀군요");
					} else if(option == JOptionPane.CANCEL_OPTION) {
						System.out.println("취소 버튼을 눌렀군요");
					} else if(option == JOptionPane.CLOSED_OPTION) {
						System.out.println("닫기 버튼을 눌렀군요");
					}
				}
			});
		}
		return btnConfirm;
	}

	//InputDialog를 보여주는 버튼 생성
	public JButton getBtnInput() {
		if(btnInput == null) {
			btnInput = new JButton();
			btnInput.setText("InputDialog");
			btnInput.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String input = null;
					
					//텍스트 입력을 받는 InputDialog을 보여줌 
					input = JOptionPane.showInputDialog(
							JOptionPaneExample.this, 
							"다이얼로그 텍스트 내용", 
							"InputDialog", 
							JOptionPane.INFORMATION_MESSAGE);
					//선택된 항목을 출력
					System.out.println("입력된 텍스트: " + input);

					//JComboBox로 항목을 선택받는 InputDialog를 보여줌
					input = (String) JOptionPane.showInputDialog(
							JOptionPaneExample.this, 
							"다이얼로그 텍스트 내용", 
							"InputDialog", 
							JOptionPane.PLAIN_MESSAGE, 
							null, 
							new String[] {"Java", "JDBC", "JSP", "Spring"}, 
							"JDBC");
					//선택된 항목을 출력
					System.out.println("선택된 항목: " + input);
				}
			});
		}
		return btnInput;
	}

	//OptionDialog를 보여주는 버튼 생성
	public JButton getBtnOption() {
		if(btnOption == null) {
			btnOption = new JButton();
			btnOption.setText("OptionDialog");
			btnOption.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//OptionDialog를 보여줌
					int option = JOptionPane.showOptionDialog(
							JOptionPaneExample.this,
							"다이얼로그의 텍스트 내용", 
							"OptionDialog", 
							JOptionPane.YES_NO_OPTION, 
							JOptionPane.INFORMATION_MESSAGE, 
							null, 
							new String[] {"시작", "종료"}, 
							"시작");
					//클릭된 버튼 확인하기
					if(option == 0) {
						System.out.println("시작 버튼을 눌렀군요");
					} else if(option == 1) {
						System.out.println("종료 버튼을 눌렀군요");
					}
				}
			});
		}
		return btnOption;
	}
	
	public static void main(String[] args) {
	    SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	        	JOptionPaneExample jFrame = new JOptionPaneExample();
	        	jFrame.setVisible(true);
	        }
	    });
	}
}



