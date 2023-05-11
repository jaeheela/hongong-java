package sec11.exam01_jmenu;

import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;

public class JMenuExample extends JFrame {
	private JMenuBar jMenuBar;
	private JMenu menuFile, menuNew, menuHelp;
	private JMenuItem menuItemNewFile, menuItemNewFolder;
	private JMenuItem menuItemOpen, menuItemSave, menuItemExit;

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
			//메뉴 추가
			jMenuBar.add(getMenuFile());
			jMenuBar.add(getMenuHelp());
		}
		return jMenuBar;
	}

	//파일 메뉴 생성
	public JMenu getMenuFile() {
		if (menuFile == null) {
			menuFile = new JMenu("파일");
			//서브 메뉴와 메뉴 아이템 추가
			menuFile.add(getMenuNew());
			menuFile.add(getMenuItemOpen());
			menuFile.add(getMenuItemSave());
			menuFile.add(new JSeparator());
			menuFile.add(getMenuItemExit());
		}
		return menuFile;
	}

	//도움말 메뉴 생성
	public JMenu getMenuHelp() {
		if (menuHelp == null) {
			menuHelp = new JMenu("도움말");
		}
		return menuHelp;
	}

	//새로 만들기 서브 메뉴 생성
	public JMenu getMenuNew() {
		if (menuNew == null) {
			menuNew = new JMenu("새로 만들기");
			//메뉴 아이템 추가
			menuNew.add(getMenuItemNewFile());
			menuNew.add(getMenuItemNewFolder());
		}
		return menuNew;
	}

	//새 파일 메뉴 아이템 생성
	public JMenuItem getMenuItemNewFile() {
		if (menuItemNewFile == null) {
			menuItemNewFile = new JMenuItem("새 파일");
		}
		return menuItemNewFile;
	}

	//새 폴더 메뉴 아이템 생성
	public JMenuItem getMenuItemNewFolder() {
		if (menuItemNewFolder == null) {
			menuItemNewFolder = new JMenuItem("새 폴더");
		}
		return menuItemNewFolder;
	}

	//파일 열기 메뉴 아이템 생성
	public JMenuItem getMenuItemOpen() {
		if (menuItemOpen == null) {
			menuItemOpen = new JMenuItem("파일 열기", 
					new ImageIcon(getClass().getResource("open.gif")));
		}
		return menuItemOpen;
	}

	//파일 저장 메뉴 아이템 생성
	public JMenuItem getMenuItemSave() {
		if (menuItemSave == null) {
			menuItemSave = new JCheckBoxMenuItem("파일 저장");
		}
		return menuItemSave;
	}

	//종료 메뉴 아이템 생성
	public JMenuItem getMenuItemExit() {
		if (menuItemExit == null) {
			menuItemExit = new JMenuItem("종료");
		}
		return menuItemExit;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JMenuExample jFrame = new JMenuExample();
				jFrame.setVisible(true);
			}
		});
	}
}



