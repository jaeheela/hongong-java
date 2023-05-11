package sec03.exam04_jtabbedpane;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class JTabbedPaneExample extends JFrame {
	private JTabbedPane jTabbedPane;
	private JPanel tab1Panel;
	private JPanel tab2Panel;

	//메인 윈도우 설정
	public JTabbedPaneExample() {
		this.setTitle("JTabbedPaneExample");		
		this.setSize(300, 200);	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(getJTabbedPane(), BorderLayout.CENTER);
	}
	
	//JTabbedPane 생성 및 Tab추가
	private JTabbedPane getJTabbedPane() {
		if (jTabbedPane == null) {
			jTabbedPane = new JTabbedPane();
			jTabbedPane.setTabPlacement(JTabbedPane.LEFT);
			jTabbedPane.addTab("탭1", getTab1Panel());
			jTabbedPane.addTab("탭2", getTab2Panel());
		}
		return jTabbedPane;
	}
	
	//Tab1에 추가된 JPanel 생성
	private JPanel getTab1Panel() {
		if(tab1Panel == null) {
			tab1Panel = new JPanel();
			JLabel jLabel = new JLabel();
			jLabel.setIcon(new ImageIcon(getClass().getResource("duke1.gif")));
			tab1Panel.add(jLabel);
		}
		return tab1Panel;
	}

	//Tab2에 추가될 JPanel 생성
	private JPanel getTab2Panel() {
		if(tab2Panel == null) {
			tab2Panel = new JPanel();
			JLabel jLabel = new JLabel();
			jLabel.setIcon(new ImageIcon(getClass().getResource("duke2.gif")));
			tab2Panel.add(jLabel);
		}
		return tab2Panel;
	}
	
	public static void main(String[] args) {
	    SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	        	JTabbedPaneExample jFrame = new JTabbedPaneExample();
	        	jFrame.setVisible(true);
	        }
	    });
	}	
}

