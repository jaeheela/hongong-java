package sec11.exam02_eventhandling;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class JMenuExample extends JFrame {
	private JMenuBar jMenuBar;
	private JMenu menuFile;
	private JMenuItem menuItemSave, menuItemExit;

	//메인 윈도우 설정
	public JMenuExample() {
		this.setTitle("JMenuExample");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(getJMenuBar());
		this.setSize(300, 200);
	}

	//JMenuBar 생성
	public JMenuBar getJMenuBar() {
		if (jMenuBar == null) {
			jMenuBar = new JMenuBar();
			jMenuBar.add(getMenuFile());
		}
		return jMenuBar;
	}

	//파일 메뉴 생성
	public JMenu getMenuFile() {
		if (menuFile == null) {
			menuFile = new JMenu("파일");
			menuFile.add(getMenuItemSave());
			menuFile.add(getMenuItemExit());
		}
		return menuFile;
	}

	//파일 저장 메뉴 아이템 생성
	public JMenuItem getMenuItemSave() {
		if (menuItemSave == null) {
			menuItemSave = new JCheckBoxMenuItem("파일 저장");
			menuItemSave.addActionListener(actionListener);
		}
		return menuItemSave;
	}

	//종료 메뉴 아이템 생성
	public JMenuItem getMenuItemExit() {
		if (menuItemExit == null) {
			menuItemExit = new JMenuItem("종료");
			menuItemExit.addActionListener(actionListener);
		}
		return menuItemExit;
	}

	//메뉴 선택 이벤트를 처리하는 ActionListener 필드 선언
	private ActionListener actionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == menuItemSave) {
				if (menuItemSave.isSelected()) {
					JOptionPane.showMessageDialog(
							JMenuExample.this, "해제 상태 >> 체크 상태.");
				} else {
					JOptionPane.showMessageDialog(
							JMenuExample.this, "체크 상태 >> 해제 상태.");
				}
			} else if (e.getSource() == menuItemExit) {
				System.exit(0);
			}
		}
	};

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JMenuExample jFrame = new JMenuExample();
				jFrame.setVisible(true);
			}
		});
	}
}
