package sec09.exam03_cellrenderer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class JTableExample extends JFrame {
	private JTable jTable;

	//메인 윈도우 설정
	public JTableExample() {
		this.setTitle("JTableExample");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(new JScrollPane(getJTable()), BorderLayout.CENTER);
		this.setSize(200, 125);
	}

	//JTable 생성
	public JTable getJTable() {
		if (jTable == null) {
			String[] columnNames = { "이름", "나이", "선택" };
			Object[][] rowData = { 
				{ "춘삼월", 25, false },
				{ "하여름", 26, true }, 
				{ "추가을", 22, false },
				{ "동겨울", 27, true }
			};
			
			jTable = new JTable(rowData, columnNames);
			
			//각 컬럼의 셀 렌더러 변경
			TableColumn tcName = jTable.getColumn("이름");
			tcName.setCellRenderer(new NameTableCellRenderer());			
			TableColumn tcAge = jTable.getColumn("나이");
			tcAge.setCellRenderer(new AgeTableCellRenderer());			
			TableColumn tcSelect = jTable.getColumn("선택");
			tcSelect.setCellRenderer(new SelectTableCellRenderer());
		}
		return jTable;
	}

	//이름 컬럼의 셀 렌더러 정의
	public class NameTableCellRenderer extends JLabel implements TableCellRenderer {
		public Component getTableCellRendererComponent(
				JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			setText(value.toString());
			setFont(new Font(null, Font.PLAIN, 12));
			setHorizontalAlignment(JLabel.CENTER);
			setOpaque(true); //JLabel의 배경을 불투명하게 설정
			if (isSelected) {
				setBackground(Color.YELLOW);
			} else {
				setBackground(Color.WHITE);
			}
			return this;
		}
	}

	//나이 컬럼의 셀 렌더러 정의
	public class AgeTableCellRenderer extends JLabel implements TableCellRenderer {
		public Component getTableCellRendererComponent(
				JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			int age = ((Integer) value).intValue();
			if (age <= 25) {
				setIcon(new ImageIcon(getClass().getResource("key.gif")));
			} else {
				setIcon(new ImageIcon(getClass().getResource("start.gif")));
			}
			setText(value.toString());
			setFont(new Font(null, Font.PLAIN, 12));
			setHorizontalAlignment(JLabel.CENTER);
			setOpaque(true); //JLabel의 배경을 불투명하게 설정
			if (isSelected) {
				setBackground(Color.YELLOW);
			} else {
				setBackground(Color.WHITE);
			}
			return this;
		}
	}

	//선택 컬럼의 셀 렌더러 정의
	public class SelectTableCellRenderer extends JCheckBox 
												implements TableCellRenderer {
		public Component getTableCellRendererComponent(
				JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			Boolean boolWrapper = (Boolean) value;
			setSelected(boolWrapper.booleanValue());
			setHorizontalAlignment(CENTER);
			if (isSelected) {
				setBackground(Color.YELLOW);
			} else {
				setBackground(Color.WHITE);
			}
			return this;
		}
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


