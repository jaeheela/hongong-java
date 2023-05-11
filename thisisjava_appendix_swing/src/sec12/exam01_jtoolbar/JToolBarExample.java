package sec12.exam01_jtoolbar;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.border.SoftBevelBorder;

public class JToolBarExample extends JFrame {
	private JMenuBar jMenuBar;
	private JToolBar jToolBar;
	private JButton btnNew, btnSave, btnCopy, btnPaste;

	//메인 윈도우 설정
	public JToolBarExample() {
		this.setTitle("JFrame");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(getJMenuBar());
		
		//JToolBar를 JFrame의 북쪽에 배치
		this.getContentPane().add(getJToolBar(), BorderLayout.NORTH);
		
		this.setSize(300, 200);
	}

	//JMenuBar 생성
	public JMenuBar getJMenuBar() {
		if (jMenuBar == null) {
			jMenuBar = new JMenuBar();
			jMenuBar.add(new JMenu("파일"));
			jMenuBar.add(new JMenu("도움말"));
		}
		return jMenuBar;
	}

	//JToolBar 생성
	public JToolBar getJToolBar() {
		if (jToolBar == null) {
			jToolBar = new JToolBar();
			jToolBar.add(getBtnNew());
			jToolBar.add(getBtnSave());
			jToolBar.addSeparator();
			jToolBar.add(getBtnCopy());
			jToolBar.add(getBtnPaste());
		}
		return jToolBar;
	}

	//JToolBar의 New 버튼 생성
	public JButton getBtnNew() {
		if (btnNew == null) {
			btnNew = new JButton();
			btnNew.setIcon(new ImageIcon(getClass().getResource("new.gif")));
			btnNew.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
			btnNew.setToolTipText("새로만들기");
			btnNew.addActionListener(actionListener);
		}
		return btnNew;
	}

	//JToolBar의 Save 버튼 생성
	public JButton getBtnSave() {
		if (btnSave == null) {
			btnSave = new JButton();
			btnSave.setIcon(new ImageIcon(getClass().getResource("save.gif")));
			btnSave.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
			btnSave.setToolTipText("저장");
			btnSave.addActionListener(actionListener);
		}
		return btnSave;
	}

	//JToolBar의 Copy 버튼 생성
	public JButton getBtnCopy() {
		if (btnCopy == null) {
			btnCopy = new JButton();
			btnCopy.setIcon(new ImageIcon(getClass().getResource("copy.gif")));
			btnCopy.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
			btnCopy.setToolTipText("복사");
			btnCopy.addActionListener(actionListener);
		}
		return btnCopy;
	}

	//JToolBar의 Paste 버튼 생성
	public JButton getBtnPaste() {
		if (btnPaste == null) {
			btnPaste = new JButton();
			btnPaste.setIcon(new ImageIcon(getClass().getResource("paste.gif")));
			btnPaste.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
			btnPaste.setToolTipText("붙여넣기");
			btnPaste.addActionListener(actionListener);
		}
		return btnPaste;
	}

	//JToolBar의 버튼 이벤트 처리
	private ActionListener actionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnNew) {
				JOptionPane.showMessageDialog(JToolBarExample.this, "[새로만들기]를 클릭");
			} else if (e.getSource() == btnSave) {
				JOptionPane.showMessageDialog(JToolBarExample.this, "[저장]를 클릭");
			} else if (e.getSource() == btnCopy) {
				JOptionPane.showMessageDialog(JToolBarExample.this, "[복사]를 클릭");
			} else if (e.getSource() == btnPaste) {
				JOptionPane.showMessageDialog(JToolBarExample.this, "[붙여넣기]를 클릭");
			}
		}
	};

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JToolBarExample jFrame = new JToolBarExample();
				jFrame.setVisible(true);
			}
		});
	}
}

