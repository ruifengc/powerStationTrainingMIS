package forms.employee;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JDesktopPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyVetoException;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class MainForm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm frame = new MainForm();
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
	public MainForm() {
		setTitle("\u7535\u5382\u804C\u5DE5\u57F9\u8BAD\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF PowerStationMIS V1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 611);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnEmployee = new JMenu("\u5458\u5DE5\u7BA1\u7406");
		menuBar.add(mnEmployee);
		
		JMenuItem mntmAddEmployee = new JMenuItem("\u6DFB\u52A0\u5458\u5DE5");
		
		mnEmployee.add(mntmAddEmployee);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		JButton btnAddEmployee = new JButton("\u6DFB\u52A0\u5458\u5DE5");
		btnAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showEmployeeMainForm();
			}
		});
		toolBar.add(btnAddEmployee);
		
		JButton btnNewButton_1 = new JButton("\u6DFB\u52A0\u90E8\u95E8");
		toolBar.add(btnNewButton_1);
		
		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JLabel lblNewLabel = new JLabel("\u2605\u592A\u539F\u79D1\u6280\u5927\u5B66  \u8BA1\u7B97\u673A\u5B66\u9662\u2605");
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("»ªÎÄÁ¥Êé", Font.PLAIN, 13));
		panel.add(lblNewLabel);
		
		mntmAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showEmployeeMainForm();
			}
		});
	}
	
	private void showEmployeeMainForm(){
		EmployeeMainForm emf = new EmployeeMainForm();
		
		desktopPane.add(emf);
		emf.setVisible(true);
		try {
			emf.setMaximum(true);
		} catch (PropertyVetoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
