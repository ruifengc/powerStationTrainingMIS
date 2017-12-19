package forms.scores;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

import util.DateChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import dto.KeyValue;
import dto.department.DepartDTO;
import dto.scores.ScoresDTO;
import forms.employee.SelectDepForm;

import java.awt.Color;

import services.Duty;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import services.Education;
import services.scores.Scores;
import services.user.User;

public class AddScores extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField txtName;
	private JTextField txtAttendance;
	private JTextField txtTest;
	private JTextField txtDep;
	
	private KeyValue<String,DepartDTO> seleDep = null;
	SelectDepForm selectDepForm = null;
	private String selectedDuty = null;
	private String selectedEdu = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddScores dialog = new AddScores();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddScores() {
		setTitle("\u6DFB\u52A0\u5458\u5DE5\u4FE1\u606F");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 629, 406);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel.setBounds(45, 72, 54, 15);
		contentPanel.add(lblNewLabel);
		
		txtName = new JTextField();
		txtName.setBounds(107, 63, 173, 33);
		contentPanel.add(txtName);
		txtName.setColumns(10);
		
		JLabel label = new JLabel("\u8003\u52E4\u6210\u7EE9\uFF1A");
		label.setBounds(45, 171, 79, 15);
		contentPanel.add(label);
		
		txtAttendance = new JTextField();
		txtAttendance.setColumns(10);
		txtAttendance.setBounds(107, 162, 173, 33);
		contentPanel.add(txtAttendance);
		
		JLabel label_1 = new JLabel("\u8003\u8BD5\u6210\u7EE9\uFF1A");
		label_1.setBounds(301, 171, 54, 15);
		contentPanel.add(label_1);
		
		txtTest = new JTextField();
		txtTest.setColumns(10);
		txtTest.setBounds(365, 159, 155, 36);
		contentPanel.add(txtTest);
		
		JLabel label_2 = new JLabel("\u90E8\u95E8\uFF1A");
		label_2.setBounds(301, 72, 54, 15);
		contentPanel.add(label_2);
		
		txtDep = new JTextField();
		txtDep.addMouseListener(new MouseAdapter() {
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
				txtDep.setText(seleDep.getKey());
				txtDep.setVisible(true);
			}
			
		});
		txtDep.setColumns(10);
		txtDep.setBounds(363, 63, 173, 33);
		contentPanel.add(txtDep);
		ButtonGroup sexRdbtn  =  new ButtonGroup();
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("\u4FDD\u5B58");
				okButton.addActionListener(this);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("\u9000\u51FA");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//保存
		ScoresDTO ScoresDTO = this.generateScoresDTO();
		Scores scores = new Scores();
		scores.saveScores(ScoresDTO);
		System.out.println("ScoresDTO: - -"+ScoresDTO);
		
	}
	
	public boolean  validateScores(){
		boolean validated = false;
		
		return validated;
	}
	
	private ScoresDTO generateScoresDTO(){
		ScoresDTO ScoresDTO = new ScoresDTO();
		
		ScoresDTO.setUser_name(txtName.getText().trim());//姓名
		ScoresDTO.setUnit_name(txtDep.getText());;//性别
		ScoresDTO.setAttendance_score(txtAttendance.getText());
		ScoresDTO.setTest_score(txtTest.getText());
		return ScoresDTO;
		
	}
}
