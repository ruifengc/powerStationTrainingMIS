package forms.scores;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JToolBar;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.RowSorter;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JPanel;

import dto.KeyValue;
import services.depart.Depart;
import services.scores.Scores;
import services.user.User;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Vector;
import java.awt.FlowLayout;


public class ScoresMainForm extends JInternalFrame {
	private JTable tblEmployee;
	private Vector<String> colums;
	private Vector<Vector<Object>> tableDatas;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoresMainForm frame = new ScoresMainForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ScoresMainForm() {
		setClosable(true);
		setBounds(100, 100, 978, 679);
		
	    JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		tblEmployee = new JTable();

		
		tableDatas = new Scores().getAllScoress();
		
	 colums = new Vector<String>();
//		colums.add("编号");
		colums.add("姓名");
		colums.add("部门名");
		colums.add("平时成绩");
		colums.add("考试成绩");
		colums.add("总分");
		
		
		DefaultTableModel tableModel = new DefaultTableModel(tableDatas,colums);
		RowSorter sorter = new TableRowSorter<DefaultTableModel>(tableModel);
		
		
		tblEmployee.setRowHeight(30);
		tblEmployee.setRowSorter(sorter);
		tblEmployee.setModel(tableModel);
		//this.hideTableColumn(tblEmployee, 6);
		scrollPane.setViewportView(tblEmployee);		
//		scrollPane.setColumnHeaderView(tblEmployee);
		
		JToolBar toolBar_1 = new JToolBar();
		panel.add(toolBar_1, BorderLayout.NORTH);
		
		JButton btnNewButton_1 = new JButton("\u6DFB\u52A0");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddScores addEmp = new AddScores();
				addEmp.setVisible(true);
			}
		});
		toolBar_1.add(btnNewButton_1);
		
		JButton btnDel = new JButton("\u5220\u9664");
		btnDel.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String delScoresId = getSelectedEmployeeId();
				Scores scores = new Scores();
				scores.delScores(delScoresId);
			}

			
		});
		toolBar_1.add(btnDel);
		
		JButton btnUpdate = new JButton("\u4FEE\u6539");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//修改
				String Id = getSelectedEmployeeId();
				System.out.println(Id);
				Scores scores = new Scores();
				scores.delScores(Id);
				AddScores addEmp = new AddScores();
				addEmp.setVisible(true);
			}
		});
		btnUpdate.setHorizontalAlignment(SwingConstants.LEFT);
		toolBar_1.add(btnUpdate);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		toolBar_1.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//查询---
				tableDatas = new Scores().getAllScoress();
				DefaultTableModel tableModel = new DefaultTableModel(tableDatas,colums);
				tblEmployee.setModel(tableModel);
				tblEmployee.setRowHeight(30);
				RowSorter sorter = new TableRowSorter<DefaultTableModel>(tableModel);
				tblEmployee.setRowSorter(sorter);
				tblEmployee.setModel(tableModel);
//				
				


			}
		});
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.TRAILING);
		toolBar_1.add(panel_2);
		
		String format ="共计部门：%d个";
	}
	
	
	private void hideTableColumn(JTable table, int column){  
	    TableColumnModel tcm = table.getColumnModel();  
	    //其实没有移除，仅仅隐藏而已  
	    TableColumn tc = tcm.getColumn(column);
	    tcm.removeColumn(tc);         
	}  
	
	private String  getSelectedEmployeeId() {
		int row = tblEmployee.getSelectedRow();

		if(row == -1)
			return "";
		
		KeyValue<String, String> k = (KeyValue<String, String>)tblEmployee.getValueAt(row, 0);
		System.out.println(k.getValue()+k.getKey());
		
		return k.getValue();
	}
}
