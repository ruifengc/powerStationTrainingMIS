package forms.training;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
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

import util.CommUtil;
import util.DateChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import dto.KeyValue;
import dto.UserDTO;
import dto.department.DepartDTO;
import dto.training.TrainingDTO;
import forms.employee.SelectDepForm;
import persistences.training.TrainingDAOOptimization;

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
import services.training.Training;
import services.user.User;

public class AddTrainingForm extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField txtName;
	private JComboBox<String> cmbClass;
	private JComboBox<String> cmbYear;
	private JComboBox<String> combStatic;
	private TrainingDAOOptimization sm = null;  
	
	private KeyValue<String,DepartDTO> seleDep = null;
	SelectDepForm selectDepForm = null;
	private String selectedDuty = null;
	private String selectedEdu = null;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddTrainingForm dialog = new AddTrainingForm();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddTrainingForm() {
		setTitle("\u6DFB\u52A0\u57F9\u8BAD\u4FE1\u606F");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 629, 406);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u57F9\u8BAD\u540D\uFF1A");
		lblNewLabel.setBounds(45, 72, 54, 15);
		contentPanel.add(lblNewLabel);
		
		txtName = new JTextField();
		txtName.setBounds(107, 63, 173, 33);
		contentPanel.add(txtName);
		txtName.setColumns(10);
		DateChooser dateChooser1 = DateChooser.getInstance("yyyy-MM-dd");
		ButtonGroup sexRdbtn  =  new ButtonGroup();
		
		JLabel label_4 = new JLabel("\u57F9\u8BAD\u7C7B\u578B\uFF1A");
		label_4.setBounds(45, 213, 54, 15);
		contentPanel.add(label_4);
		
		
		cmbClass = new JComboBox();
		
		cmbClass.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED){
					String selDuty = (String)e.getItem();
					selectedDuty = Duty.getIndex(selDuty);
					System.out.println("Selected item is "+Duty.getIndex(selDuty));
				}
			}
		});
		cmbClass.setBackground(Color.WHITE);
		cmbClass.setForeground(Color.BLACK);
		cmbClass.setModel(new DefaultComboBoxModel(new String[] {"\u65B0\u5458\u5DE5\u5165\u5382\u57F9\u8BAD", "\u4E2D\u5C42\u7BA1\u7406\u4EBA\u5458\u57F9\u8BAD", "\u73ED\u7EC4\u957F\u57F9\u8BAD"}));
		cmbClass.setBounds(105, 202, 175, 36);
		contentPanel.add(cmbClass);
		
		cmbYear = new JComboBox();
		cmbYear.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String selEdu = (String)e.getItem();
				selectedEdu = Education.getIndex(selEdu);
			}
		});
		cmbYear.setModel(new DefaultComboBoxModel(new String[] {"2015", "2016", "2017"}));
		cmbYear.setForeground(Color.BLACK);
		cmbYear.setBackground(Color.WHITE);
		cmbYear.setBounds(384, 60, 155, 36);
		contentPanel.add(cmbYear);
		
		JLabel label_5 = new JLabel("\u57F9\u8BAD\u5E74\u4EFD\uFF1A");
		label_5.setBounds(320, 71, 54, 15);
		contentPanel.add(label_5);
		
		combStatic = new JComboBox();
		combStatic.setModel(new DefaultComboBoxModel(new String[] {"\u672A\u57F9\u8BAD", "\u57F9\u8BAD\u4E2D", "\u5DF2\u57F9\u8BAD"}));
		combStatic.setForeground(Color.BLACK);
		combStatic.setBackground(Color.WHITE);
		combStatic.setBounds(384, 202, 173, 36);
		contentPanel.add(combStatic);
		
		JLabel label_6 = new JLabel("\u57F9\u8BAD\u8FDB\u5EA6\uFF1A");
		label_6.setBounds(322, 213, 54, 15);
		contentPanel.add(label_6);
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
		
		//----------------------------
		TrainingDTO trainingDTO = this.generateTrainingDTO();
		Training training = new Training();
		training.saveTraining(trainingDTO);
//		
	}
    private TrainingDTO generateTrainingDTO(){
        TrainingDTO trainingDTO = new TrainingDTO();
        
        trainingDTO.setTrain_plan_name(txtName.getText());
        trainingDTO.setTrain_plan_type((String) cmbClass.getSelectedItem());
        trainingDTO.setTrain_plan_year((String) cmbYear.getSelectedItem());
        trainingDTO.setIs_finish((String) combStatic.getSelectedItem());
        return trainingDTO;
        
    }
	public boolean  validateEmployee(){
		boolean validated = false;
		
		return validated;
	}
//	private void insert(String []paras){
//		   sm = new TrainingDAO();
//	       sm.cudTrain("insert into train_plan_info (TRAIN_PLAN_ID,TRAIN_PLAN_NAME,TRAIN_PLAN_TYPE,TRAIN_PLAN_YEAR,IS_FINISH) values(?,?,?,?,?)", paras);
//			//-----------------------------
//	}
	   

}