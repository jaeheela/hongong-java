package sec15.exam03;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class BoardApp extends JFrame {
	private JTable jTable;
	private JPanel pSouth;
	private JButton btnInsert;
	//////////////////////////////////////////////////////////////
	private List<Board> list = new ArrayList<Board>();
	//////////////////////////////////////////////////////////////
	
	public BoardApp() {
		this.setTitle("게시판 리스트");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(new JScrollPane(getJTable()), BorderLayout.CENTER);
		this.getContentPane().add(getPSouth(), BorderLayout.SOUTH);
		this.setSize(600, 450);
	}
	
	public JTable getJTable() {
		if(jTable == null) {
			jTable = new JTable();
			
			DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
			tableModel.addColumn("번호");
			tableModel.addColumn("제목");
			tableModel.addColumn("글쓴이");
			tableModel.addColumn("날짜");
			tableModel.addColumn("조회수");
			
			jTable.getColumn("번호").setPreferredWidth(20);
			jTable.getColumn("제목").setPreferredWidth(250);
			jTable.getColumn("글쓴이").setPreferredWidth(50);
			jTable.getColumn("날짜").setPreferredWidth(50);
			jTable.getColumn("조회수").setPreferredWidth(20);
			
			CenterTableCellRenderer ctcr = new CenterTableCellRenderer();
			jTable.getColumn("번호").setCellRenderer(ctcr);
			jTable.getColumn("제목").setCellRenderer(ctcr);
			jTable.getColumn("글쓴이").setCellRenderer(ctcr);
			jTable.getColumn("날짜").setCellRenderer(ctcr);
			jTable.getColumn("조회수").setCellRenderer(ctcr);
			
			///////////////////////////////////////////////////////
			jTable.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					int rowIndex = jTable.getSelectedRow();
					if(rowIndex !=-1) {
						Board board = list.get(rowIndex);
						ViewDialog viewDialog = new ViewDialog(BoardApp.this);
						viewDialog.setBoard(board);
						viewDialog.setVisible(true);
					}
				}		
			});
			///////////////////////////////////////////////////////
		}
		return jTable;
	}
	
	public class CenterTableCellRenderer extends JLabel implements TableCellRenderer {
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			setText(value.toString());
			setFont(new Font(null, Font.PLAIN, 12));
			setHorizontalAlignment(JLabel.CENTER);
			setOpaque(true);
			if(isSelected) { setBackground(Color.YELLOW); } 
			else { setBackground(Color.WHITE); }
			return this;
		}
	}	
	
	public JPanel getPSouth() {
		if(pSouth == null) {
			pSouth = new JPanel();
			pSouth.add(getBtnInsert());
		}
		return pSouth;
	}

	public JButton getBtnInsert() {
		if(btnInsert == null) {
			btnInsert = new JButton();
			btnInsert.setText("추가");
			btnInsert.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					InsertDialog insertDialog = new InsertDialog(BoardApp.this);
					insertDialog.setVisible(true);
				}
			});
		}
		return btnInsert;
	}
	
	public static void main(String[] args) {
	    SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	        	BoardApp jFrame = new BoardApp();
	        	jFrame.setVisible(true);
	        }
	    });
	}	
	
	public void addBoard(Board board) {
		DefaultTableModel tableModel = (DefaultTableModel) getJTable().getModel();
		board.setNo(getLastNo() + 1);
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH) + 1;
		int day = now.get(Calendar.DAY_OF_MONTH);
		String date = ""+ year + "." + month + "." + day;
		board.setDate(date);
		list.add(board);
		Object[] rowData = { board.getNo(), board.getTitle(), board.getWriter(), board.getDate(), board.getHitcount() };
		tableModel.addRow(rowData);
	}
	
	public int getLastNo() {
		int no = 0;
		for(Board board: list) {
			if(no<board.getNo()) {
				no = board.getNo();
			}
		}
		return no;
	}
	
	////////////////////////////////////////////////////////////
	public void updateBoard(Board board) {
		DefaultTableModel tableModel = (DefaultTableModel) getJTable().getModel();
		Vector rows = tableModel.getDataVector();
		for(int i=0; i<rows.size(); i++) {
			Vector row = (Vector) rows.elementAt(i);
			if(board.getNo() == (Integer)row.elementAt(0)) {
				row.set(1, board.getTitle());
				row.set(2, board.getWriter());
			}
		}
		tableModel.fireTableDataChanged();
	}
	
	public void deleteBoard(Board board) {
		list.remove(board);
		DefaultTableModel tableModel = (DefaultTableModel) getJTable().getModel();
		Vector rows = tableModel.getDataVector();
		for(int i=0; i<rows.size(); i++) {
			Vector row = (Vector) rows.elementAt(i);
			if(board.getNo() == (Integer)row.elementAt(0)) {
				rows.remove(row);
				i--;
			}
		}
		tableModel.fireTableDataChanged();
	}
	////////////////////////////////////////////////////////////
}
