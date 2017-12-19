package forms.depart;

import java.awt.EventQueue;
import javax.swing.JFrame;
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
import dto.department.DepartDTO;
import forms.employee.SelectDepForm;
import services.depart.Depart;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Vector;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

	public class DepartForm extends JInternalFrame{
		private Vector<String> colums;
		private Vector<Vector<Object>> tableDatas;
		private JTextField textField;
		private SelectDepForm selectDepForm;
		private KeyValue<String,DepartDTO> seleDep = null;
		private JTextField textNewField;
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						DepartForm frame = new DepartForm();
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
		public DepartForm() {
			setClosable(true);
			setBounds(100, 100, 978, 679);
			
			JPanel panel = new JPanel();
			getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel label = new JLabel("\u90E8\u95E8\u9009\u62E9\uFF1A");
			label.setFont(new Font("宋体", Font.PLAIN, 17));
			label.setBounds(36, 86, 94, 18);
			panel.add(label);
			
			textField = new JTextField();
			textField.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					selectDepForm = new  SelectDepForm();
					selectDepForm.setVisible(true);	
				}
				@Override
				public void mouseExited(MouseEvent e) {
					if(selectDepForm == null) 
						return;
					
					seleDep = selectDepForm.getSelectedDep();
					if(seleDep == null) 
						return;
					System.out.println("mouse exited.....");
					System.out.println(seleDep.getKey());
					textField.setText(seleDep.getKey());
					textField.setVisible(true);
				}
			});
			textField.setColumns(10);
			textField.setBounds(133, 79, 173, 33);
			panel.add(textField);
			
			JToolBar toolBar = new JToolBar();
			toolBar.setBounds(0, 0, 962, 20);
			panel.add(toolBar);
			
			JButton button = new JButton("  \u65B0\u589E\u5B50\u90E8\u95E8  ");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//新增子部门
					Depart depart = new Depart();
					DepartDTO dto = new DepartDTO();
					dto.setUp_unit_id(depart.getUpNum(textField.getText()));
					dto.setUnit_name(textNewField.getText());
					depart.saveSubDepart(dto);
				}
			});
			toolBar.add(button);
			
			JButton button_1 = new JButton("  \u4FEE\u6539\u5F53\u524D\u90E8\u95E8  ");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//修改
					Depart depart = new Depart();
					DepartDTO dto = new DepartDTO();
					dto.setUnit_name(textField.getText());
					depart.modifyDepart(dto, textNewField.getText());
				}
			});
			toolBar.add(button_1);
			
			JButton button_2 = new JButton("  \u5220\u9664\u8BE5\u90E8\u95E8  ");
			button_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Depart depart = new Depart();
					DepartDTO dto = new DepartDTO();
					dto.setUnit_name(textField.getText());
					depart.delDepart(dto);
				}
			});
			toolBar.add(button_2);
			
			JLabel label_1 = new JLabel("\u90E8\u95E8\u540D\u79F0\uFF1A");
			label_1.setFont(new Font("宋体", Font.PLAIN, 17));
			label_1.setBounds(36, 163, 94, 18);
			panel.add(label_1);
			
			textNewField = new JTextField();
			textNewField.setBounds(133, 159, 173, 29);
			panel.add(textNewField);
			textNewField.setColumns(10);

			
			
			
		 colums = new Vector<String>();
//			colums.add("编号");
			colums.add("姓名");
			colums.add("部门名");
			colums.add("平时成绩");
			colums.add("考试成绩");
			colums.add("总分");
			
			
			DefaultTableModel tableModel = new DefaultTableModel(tableDatas,colums);
			RowSorter sorter = new TableRowSorter<DefaultTableModel>(tableModel);
			
			String format ="共计部门：%d个";
		}
		
		
		private void hideTableColumn(JTable table, int column){  
		    TableColumnModel tcm = table.getColumnModel();  
		    //其实没有移除，仅仅隐藏而已  
		    TableColumn tc = tcm.getColumn(column);
		    tcm.removeColumn(tc);         
		}  
	}

