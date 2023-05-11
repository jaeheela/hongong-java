package sec09.exam05_row_add_update_delete;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class JTableExample extends JFrame {
	private JTable jTable;
	private JPanel pSouth;
	private JTextField txtName, txtAge;
	private JButton btnInsert, btnUpdate, btnDelete;

	//메인 윈도우 설정
	public JTableExample() {
		this.setTitle("JTableExample");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(new JScrollPane(getJTable()), BorderLayout.CENTER);
		this.getContentPane().add(getPSouth(), BorderLayout.SOUTH);
		this.setSize(250, 250);
	}

	//JTable 생성
	public JTable getJTable() {
		if (jTable == null) {
			jTable = new JTable();
			final DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
			tableModel.addColumn("이름");
			tableModel.addColumn("나이");
			//행을 선택했을 때 이벤트 처리
			jTable.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					int rowIndex = jTable.getSelectedRow();
					if (rowIndex != -1) {
						String name = (String) tableModel.getValueAt(rowIndex, 0);
						String age = (String) tableModel.getValueAt(rowIndex, 1);
						txtName.setText(name);
						txtAge.setText(age.toString());
					}
				}
			});
		}
		return jTable;
	}

	//사용자 입력 JPanel 생성
	public JPanel getPSouth() {
		if (pSouth == null) {
			pSouth = new JPanel();

			pSouth.setLayout(new GridLayout(3, 1));

			JPanel pNameInput = new JPanel();
			pNameInput.setLayout(new GridLayout(1, 2));
			pNameInput.add(new JLabel("이름", JLabel.CENTER));
			pNameInput.add(getTxtName());
			pSouth.add(pNameInput);

			JPanel pAgeInput = new JPanel();
			pAgeInput.setLayout(new GridLayout(1, 2));
			pAgeInput.add(new JLabel("나이", JLabel.CENTER));
			pAgeInput.add(getTxtAge());
			pSouth.add(pAgeInput);

			JPanel pButton = new JPanel();
			pButton.add(getBtnInsert());
			pButton.add(getBtnUpdate());
			pButton.add(getBtnDelete());
			pSouth.add(pButton);
		}
		return pSouth;
	}

	public JTextField getTxtName() {
		if (txtName == null) {
			txtName = new JTextField();
		}
		return txtName;
	}

	public JTextField getTxtAge() {
		if (txtAge == null) {
			txtAge = new JTextField();
		}
		return txtAge;
	}

	//행 삽입 버튼 생성
	public JButton getBtnInsert() {
		if (btnInsert == null) {
			btnInsert = new JButton();
			btnInsert.setText("추가");
			btnInsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Object[] rowData = { txtName.getText(), txtAge.getText() };
					DefaultTableModel tableModel = (DefaultTableModel) getJTable().getModel();
					tableModel.addRow(rowData);
					txtName.setText("");
					txtAge.setText("");
				}
			});
		}
		return btnInsert;
	}

	//행 수정 버튼 생성
	public JButton getBtnUpdate() {
		if (btnUpdate == null) {
			btnUpdate = new JButton();
			btnUpdate.setText("수정");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DefaultTableModel tableModel = (DefaultTableModel) getJTable().getModel();
					Vector<Vector> rows = tableModel.getDataVector();
					Vector row = rows.elementAt(jTable.getSelectedRow());
					row.set(0, txtName.getText());
					row.set(1, txtAge.getText());
					tableModel.fireTableDataChanged();
					txtName.setText("");
					txtAge.setText("");
				}
			});
		}
		return btnUpdate;
	}

	//행 삭제 버튼 생성
	public JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton();
			btnDelete.setText("삭제");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int rowIndex = getJTable().getSelectedRow();
					if (rowIndex != -1) {
						DefaultTableModel tableModel = (DefaultTableModel) getJTable().getModel();
						tableModel.removeRow(rowIndex);
						txtName.setText("");
						txtAge.setText("");
					}
				}
			});
		}
		return btnDelete;
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
