package sec07.exam04_jeditpane;

import java.awt.BorderLayout;
import java.io.IOException;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class JEditorPaneExample extends JFrame {
	private JEditorPane jEditorPane;
	
	//메인 윈도우 설정
	public JEditorPaneExample() {
		this.setTitle("JEditorPaneExample");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(new JScrollPane(getJEditorPane()), BorderLayout.CENTER);
		this.setSize(400, 300);
	}
	
	//JEditorPane 생성
	public JEditorPane getJEditorPane() {
		if(jEditorPane == null) {
			jEditorPane = new JEditorPane();
			try {
				jEditorPane.setPage(getClass().getResource("jeditorpane.html"));
			} catch(Exception e) {}
			jEditorPane.setEditable(false);
			jEditorPane.addHyperlinkListener(new HyperlinkListener() {
				public void hyperlinkUpdate(HyperlinkEvent e) {
					if(e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
						try {
							jEditorPane.setPage(e.getURL());
						} catch(IOException e2) {}
					}
				}
			});
		}
		return jEditorPane;
	}
	
	public static void main(String[] args) {
	    SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	        	JEditorPaneExample jFrame = new JEditorPaneExample();
	        	jFrame.setVisible(true);
	        }
	    });
	}	
}

