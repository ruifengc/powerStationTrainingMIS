package forms.employee;

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
import services.user.User;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Vector;
import java.awt.FlowLayout;


public class EmployeeMainForm extends JInternalFrame {
	private JTextField txtEmployeeName;
	private JTable tblEmployee;
	private JLabel lblDepartCount;
	private Vector<String> colums;
	private Vector<Vector<Object>> tableDatas;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeMainForm frame = new EmployeeMainForm();
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
	public EmployeeMainForm() {
		setClosable(true);
		setBounds(100, 100, 978, 679);
		
		JToolBar toolBar = new JToolBar();
		getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		toolBar.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("\u59D3\u540D\uFF1A");
		panel_1.add(lblNewLabel);
		
		txtEmployeeName = new JTextField();
		panel_1.add(txtEmployeeName);
		txtEmployeeName.setHorizontalAlignment(SwingConstants.LEFT);
		txtEmployeeName.setColumns(20);
		
		JLabel lblNewLabel_1 = new JLabel("\u6027\u522B\uFF1A");
		panel_1.add(lblNewLabel_1);
		
		final JComboBox sexComboBox = new JComboBox();
		panel_1.add(sexComboBox);
		sexComboBox.setModel(new DefaultComboBoxModel(new String[] {"\u7537", "\u5973"}));
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//查询---
				String sex;
				
				if(sexComboBox.getSelectedItem()=="男"){
					sex = "0";
				}
				else{
					sex = "1";
				}
				tableDatas = new User().getSomeUsers(txtEmployeeName.getText(),sex);
//				Vector<String> colums = new Vector<String>();
//				colums.add("部门");
//				colums.add("姓名");
//				colums.add("出生日期");
//				colums.add("身份证");
//				colums.add("职务");
//				colums.add("Email");
//				
				DefaultTableModel tableModel = new DefaultTableModel(tableDatas,colums);
				tblEmployee.setModel(tableModel);
				tblEmployee.setRowHeight(30);
				RowSorter sorter = new TableRowSorter<DefaultTableModel>(tableModel);
				tblEmployee.setRowSorter(sorter);
				tblEmployee.setModel(tableModel);
				
//				sorter = new TableRowSorter<DefaultTableModel>(tableModel);
//						
//						
//				tblEmployee.setRowHeight(30);
//				tblEmployee.setRowSorter(sorter);
//				tblEmployee.setModel(tableModel);
//				//this.hideTableColumn(tblEmployee, 6);
//				JScrollPane scrollPane = new JScrollPane();
//				scrollPane.setViewportView(tblEmployee);		
//				panel.add(scrollPane, BorderLayout.CENTER);

			}
		});
		panel_1.add(btnNewButton);
		
	    JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		tblEmployee = new JTable();

		
		tableDatas = new User().getAllUsers();
		
	 colums = new Vector<String>();
		colums.add("部门");
		colums.add("姓名");
		colums.add("出生日期");
		colums.add("身份证");
		colums.add("职务");
		colums.add("Email");
		
		
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
				AddEmployee addEmp = new AddEmployee();
				addEmp.setVisible(true);
			}
		});
		toolBar_1.add(btnNewButton_1);
		
		JButton btnDel = new JButton("\u5220\u9664");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String delEmployId = getSelectedEmployeeId();
				System.out.println(delEmployId);
				User user = new User();
				user.delEmployee(delEmployId);
			}

			
		});
		toolBar_1.add(btnDel);
		
		JButton btnUpdate = new JButton("\u4FEE\u6539");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//修改
				String delEmployId = getSelectedEmployeeId();
				System.out.println(delEmployId);
				User user = new User();
				user.delEmployee(delEmployId);
				
				AddEmployee addEmp = new AddEmployee();
				addEmp.setVisible(true);
			}
		});
		btnUpdate.setHorizontalAlignment(SwingConstants.LEFT);
		toolBar_1.add(btnUpdate);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.TRAILING);
		toolBar_1.add(panel_2);
		
		lblDepartCount = new JLabel("");
		panel_2.add(lblDepartCount);
		
		String format ="共计部门：%d个";
		this.lblDepartCount.setText(String.format(format, new Depart().getDepartcount()));
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
		
		KeyValue<String, String> k = (KeyValue<String, String>)tblEmployee.getValueAt(row, 1);
		System.out.println(k.getValue()+k.getKey());
		
		return k.getValue();
	}
}
