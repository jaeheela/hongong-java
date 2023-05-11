package sec09.exam02_tablemodel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.TableModel;

public class JTableExample extends JFrame {
	private JTable jTable;
	private JButton btnInfo;
	
	public JTableExample() {
		this.setTitle("JTableExample");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(new JScrollPane(getJTable()), BorderLayout.CENTER);
		this.getContentPane().add(getBtnInfo(), BorderLayout.SOUTH);
		this.setSize(200, 200);
	}
	
	public JTable getJTable() {
		if(jTable == null) {
			String[] columnNames = {	"이름", "나이" };
			Object[][] rowData = {
					{"춘삼월", new Integer(25) },
			        {"하여름", new Integer(23) }
			};
			jTable = new JTable(rowData, columnNames);
		}
		return jTable;
	}
	
	public JButton getBtnInfo() {
		if(btnInfo == null) {
			btnInfo = new JButton();
			btnInfo.setText("테이블 정보 출력");
			btnInfo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//테이블 모델 얻기
					TableModel tableModel = getJTable().getModel();
					//전체 컬럼수 얻기
					int columnCount = tableModel.getColumnCount();
					//전체 행수 얻기
					int rowCount = tableModel.getRowCount();
					//컬럼 이름 출력
					for(int i=0; i<columnCount; i++) {
						String columnName = tableModel.getColumnName(i);
						System.out.print(columnName + "\t\t");
					}
					System.out.println();
					System.out.println("------------------------");
					//행의 데이터 출력
					for(int i = 0; i<rowCount; i++) {
						String column0 = (String) tableModel.getValueAt(i, 0);
						Integer column1 = (Integer) tableModel.getValueAt(i, 1);
						System.out.println(column0 + "\t\t" + column1);
					}					
					//1행 셀 데이터 변경
					tableModel.setValueAt("개나리", 0, 0);
					tableModel.setValueAt(new Integer(20), 0, 1);
				}
			});
		}
		return btnInfo;
	}
	
	public static void main(String[] args) {
	    SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	        	JTableExample jFrame = new JTableExample();
	        	jFrame.setVisible(true);
	        }
	    });
	}
}


