package forms.training;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.RowSorter;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import dto.KeyValue;
import dto.training.TrainingDTO;
import forms.employee.AddEmployee;
import services.scores.Scores;
import services.training.Training;

import java.sql.Time;
import java.util.Vector;
public class TrainingMainForm  extends JInternalFrame{

	private JFrame frame;
	JPanel contentPane;
	private JTable table;
	private Vector<String> colums;
	private Vector<Vector<Object>> tableDatas;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrainingMainForm window = new TrainingMainForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TrainingMainForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 1008, 576);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("wwfd");
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u67E5\u8BE2\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("\u57F9\u8BAD\u8BA1\u5212\u5E74\u5EA6\uFF1A");
		panel.add(lblNewLabel);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"2015", "2016", "2017"}));
		panel.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("\u57F9\u8BAD\u4E13\u4E1A\uFF1A");
		panel.add(lblNewLabel_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"\u7535\u6C14", "\u6C7D\u673A", "\u9505\u7089"}));
		panel.add(comboBox_1);
		
		JLabel label = new JLabel("\u57F9\u8BAD\u8BA1\u5212\u7C7B\u578B\uFF1A");
		panel.add(label);
		
		final JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"\u65B0\u5458\u5DE5\u5165\u5382\u57F9\u8BAD", "\u4E2D\u5C42\u7BA1\u7406\u4EBA\u5458\u57F9\u8BAD", "\u73ED\u7EC4\u957F\u57F9\u8BAD"}));
		panel.add(comboBox_2);
		
		JLabel label_1 = new JLabel("\u5B8C\u6210\u60C5\u51B5\u57F9\u8BAD\uFF1A");
		panel.add(label_1);
		
		final JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"\u672A\u57F9\u8BAD", "\u57F9\u8BAD\u4E2D", "\u5DF2\u57F9\u8BAD"}));
		panel.add(comboBox_3);

		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//查询	
		        TrainingDTO trainingDTO = new TrainingDTO();
		        trainingDTO.setTrain_plan_type((String) comboBox_2.getSelectedItem());
		        trainingDTO.setTrain_plan_year((String) comboBox.getSelectedItem());
		        trainingDTO.setIs_finish((String) comboBox_3.getSelectedItem());
				tableDatas = new Training().getSomeTrainings(trainingDTO);
				DefaultTableModel tableModel = new DefaultTableModel(tableDatas,colums);
				table.setModel(tableModel);
				table.setRowHeight(30);
				RowSorter sorter = new TableRowSorter<DefaultTableModel>(tableModel);
				table.setRowSorter(sorter);
				table.setModel(tableModel);
			}
		});
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		panel_1.add(toolBar, BorderLayout.NORTH);
		
		JButton btnNewButton_1 = new JButton("  \u521B\u5EFA   ");
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//创建
				AddTrainingForm addTrin = new AddTrainingForm();
				addTrin.setVisible(true);
			}
		});
		toolBar.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton(" \u4FEE\u6539 ");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//修改
				String delId = getSelectedTrainingId();
				Training training = new Training();
				training.delTraining(delId);
				
				AddTrainingForm addTrin = new AddTrainingForm();
				addTrin.setVisible(true);
			}
		});
		toolBar.add(btnNewButton_2);
		
		JButton button = new JButton("  \u5220\u9664  ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//删除
				
				String delId = getSelectedTrainingId();
				Training training = new Training();
				training.delTraining(delId);
            
				
			}
		});
		
		toolBar.add(button);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.TRAILING);
		toolBar.add(panel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		
		//table.getColumnModel().getColumn(1).setPreferredWidth(114);
		scrollPane.setColumnHeaderView(table);
		tableDatas = new Training().getAllTrainings();
		
	    colums = new Vector<String>();
//		colums.add("编号");
		colums.add("培训名称");
		colums.add("培训类型");
		colums.add("培训年份");
		colums.add("是否完成");
		DefaultTableModel tableModel = new DefaultTableModel(tableDatas,colums);
		RowSorter sorter = new TableRowSorter<DefaultTableModel>(tableModel);
		
		
		table.setRowHeight(30);
		table.setRowSorter(sorter);
		table.setModel(tableModel);
		//this.hideTableColumn(tblEmployee, 6);
		scrollPane.setViewportView(table);		
	}
	
	private String  getSelectedTrainingId() {
		int row = table.getSelectedRow();

		if(row == -1)
			return "";
		
		KeyValue<String, String> k = (KeyValue<String, String>)table.getValueAt(row, 0);
		System.out.println(k.getValue()+k.getKey());
		
		return k.getValue();
	}


}
