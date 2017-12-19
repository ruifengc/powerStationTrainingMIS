package forms;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JToolBar;
import javax.swing.RowSorter;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import forms.depart.DepartForm;
import forms.employee.AddEmployee;
import forms.employee.EmployeeMainForm;
import forms.employee.SelectDepForm;
import forms.scores.AddScores;
import forms.scores.ScoresMainForm;
import forms.training.AddTrainingForm;
import forms.training.TrainingMainForm;
import forms.user.AddUserForm;
import forms.user.MainUserForm;
import forms.user.UpdateUserForm;
import services.depart.Depart;

import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
public class MainPage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Vector<Vector<Object>> tableDatas;
	private Vector<String> colums;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage("root");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private static void setFrameLoaction(JFrame frame) {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

		int width = screen.width;
		int height = screen.height;
		
		int left = (width - frame.getSize().width) / 2;
		int top = (height - frame.getSize().height) / 2;
		frame.setLocation(left, top);

	}
	/**
	 * Create the frame.
	 */
	public MainPage(final String user_name) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 838, 512);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u7CFB\u7EDF\u7BA1\u7406");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u65B0\u589E\u7528\u6237");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//打开新增用户界面
				
//				EventQueue.invokeLater(new Runnable() {
//					public void run() {
//						try {
//							MainUserForm frame = new MainUserForm();
//							setFrameLoaction(frame);
//							frame.main(null);
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//					}
//				});	
				AddUserForm emf = new AddUserForm();
				contentPane.removeAll();
				contentPane.add(emf);
				emf.setVisible(true);
				try {
					emf.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				};
			
		});
		menu.add(menuItem);
		
		JMenuItem menuItem_9 = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		menuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateUserForm emf = new UpdateUserForm(user_name);
				contentPane.removeAll();
				contentPane.add(emf);
				emf.setVisible(true);
				try {
					emf.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menu.add(menuItem_9);
		
		JMenu menu_1 = new JMenu("\u57F9\u8BAD\u8BA1\u5212\u7BA1\u7406");
		menuBar.add(menu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u65B0\u589E");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddTrainingForm addTrin = new AddTrainingForm();
				addTrin.setVisible(true);
			}
		});
		menu_1.add(mntmNewMenuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u67E5\u8BE2");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//xxiugai
				TrainingMainForm emf = new TrainingMainForm();
				contentPane.removeAll();
				contentPane.add(emf);
				emf.setVisible(true);
				try {
					emf.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menu_1.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("\u4FEE\u6539");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrainingMainForm emf = new TrainingMainForm();
				contentPane.removeAll();
				contentPane.add(emf);
				emf.setVisible(true);
				try {
					emf.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menu_1.add(menuItem_2);
		
		JMenu menu_2 = new JMenu("\u57F9\u8BAD\u6210\u7EE9\u7BA1\u7406");
		menuBar.add(menu_2);
		
		JMenuItem menuItem_3 = new JMenuItem("\u65B0\u589E");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//新增分数
				AddScores addscores = new AddScores();
				addscores.setVisible(true);
			}
		});
		menu_2.add(menuItem_3);
		
		JMenuItem menuItem_5 = new JMenuItem("\u67E5\u8BE2");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//分数查询
				ScoresMainForm emf = new ScoresMainForm();
				contentPane.removeAll();
				contentPane.add(emf);
				emf.setVisible(true);
				try {
					emf.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menu_2.add(menuItem_5);
		
		JMenuItem menuItem_4 = new JMenuItem("\u4FEE\u6539");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//成绩修改
				ScoresMainForm emf = new ScoresMainForm();
				contentPane.removeAll();
				contentPane.add(emf);
				emf.setVisible(true);
				try {
					emf.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menu_2.add(menuItem_4);
		
		JMenu menu_3 = new JMenu("\u5B66\u5458\u7BA1\u7406");
		menuBar.add(menu_3);
		
		JMenuItem menuItem_6 = new JMenuItem("\u65B0\u589E\u57F9\u8BAD\u5B66\u5458");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//新增学员
				AddEmployee addEmp = new AddEmployee();
				addEmp.setVisible(true);
				
			}
		});
		menu_3.add(menuItem_6);
		
		JMenuItem menuItem_7 = new JMenuItem("\u5B66\u5458\u4FE1\u606F\u67E5\u8BE2");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//学员管理
				EmployeeMainForm emf = new EmployeeMainForm();
				contentPane.removeAll();
				contentPane.add(emf);
				emf.setVisible(true);
				try {
					emf.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menu_3.add(menuItem_7);
		
		JMenuItem menuItem_8 = new JMenuItem("\u5B66\u5458\u4FE1\u606F\u4FEE\u6539");
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeMainForm emf = new EmployeeMainForm();
				contentPane.removeAll();
				contentPane.add(emf);
				emf.setVisible(true);
				try {
					emf.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menu_3.add(menuItem_8);
		
		JMenu menu_4 = new JMenu("\u90E8\u95E8\u7BA1\u7406");
		menuBar.add(menu_4);
		
		JMenuItem menuItem_10 = new JMenuItem("\u90E8\u95E8\u67E5\u8BE2");
		menuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//查询部门
				SelectDepForm addEmp = new SelectDepForm();
				addEmp.setVisible(true);
			}
		});
		menu_4.add(menuItem_10);
		
		JMenuItem menuItem_11 = new JMenuItem("\u90E8\u95E8\u4FEE\u6539");
		menuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//部门主界面
				DepartForm emf = new DepartForm();
				contentPane.removeAll();
				contentPane.add(emf);
				emf.setVisible(true);
				try {
					emf.setMaximum(true);
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menu_4.add(menuItem_11);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel, BorderLayout.NORTH);
		lblNewLabel.setIcon(new ImageIcon(MainPage.class.getResource("/images/bg.png")));
		
		JScrollPane scrollPane = new JScrollPane();
		
	
//		table = new JTable();
//		 colums = new Vector<String>();
//			colums.add("计划编号");
//			colums.add("计划名称");
//			colums.add("地点");
//			colums.add("电话");
//			colums.add("时间");
//			tableDatas = new Depart().getAllDeparts();
//			DefaultTableModel tableModel = new DefaultTableModel(tableDatas,colums);
//			RowSorter sorter = new TableRowSorter<DefaultTableModel>(tableModel);
//			table.setRowHeight(30);
//			table.setRowSorter(sorter);
//			table.setModel(tableModel);

//			{
//			Class[] columnTypes = new Class[] {
//				String.class, String.class, String.class, Object.class, Object.class
//			};
//			public Class getColumnClass(int columnIndex) {
//				return columnTypes[columnIndex];
//			}
//		});
//		table.getColumnModel().getColumn(1).setPreferredWidth(114);
			scrollPane.setColumnHeaderView(table);
			panel_1.add(scrollPane, BorderLayout.CENTER);
	}

}
