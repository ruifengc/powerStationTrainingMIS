package forms.user;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JTextField;

import dto.UserDTO;
import services.user.User;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddUserForm  extends JInternalFrame {

	private JPanel contentPane;
	private JTextField txtUserName;
	private JLabel lblUserNameTip;
	private JLabel lblPSWTip;

	private User user;
	private JTextField txtPassWord;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUserForm frame = new AddUserForm();
//					setFrameLoaction(frame);
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
	public AddUserForm() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 10));

		JPanel body = new JPanel();
		panel.add(body, BorderLayout.CENTER);
		body.setLayout(null);

		// 点击登录按钮事件的处理逻辑
		JButton btnRegister = new JButton("\u6CE8\u518C");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validateUser()) {
					// 如果通过语法验证，将用户信息保存到数据库中
					UserDTO userDTO = new UserDTO(txtUserName.getText(),
							txtPassWord.getText());
					User user = new User();

					// 语义验证：输入的用户是否已经存在
					boolean nameExisted = user.nameExisted(txtUserName
							.getText());
					if (!nameExisted) {
						boolean saveSuccessful = user.saveUser(userDTO);

						if (saveSuccessful) {
							System.out.println("save successful");
							JOptionPane.showMessageDialog(null, "保存成功！");
						} else {
							System.out.println("save failed");
							JOptionPane.showMessageDialog(null, "保存失败！");
						}
					}else{
						JOptionPane.showMessageDialog(null, "该用户已经存在！");
						
					}

				} else
					System.out.println("The User is not passed!");
			}
		});

		btnRegister.setBounds(152, 236, 93, 32);
		body.add(btnRegister);

		JButton btnCancle = new JButton("\u53D6\u6D88");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancle.setBounds(271, 236, 93, 32);
		body.add(btnCancle);

		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_1.setBounds(101, 48, 54, 15);
		body.add(lblNewLabel_1);

		txtUserName = new JTextField();
		txtUserName.setBounds(165, 40, 176, 32);
		body.add(txtUserName);
		txtUserName.setColumns(10);
		JLabel lblNewLabel_2 = new JLabel("\u5BC6   \u7801\uFF1A");
		lblNewLabel_2.setBounds(101, 90, 54, 15);
		body.add(lblNewLabel_2);

		lblUserNameTip = new JLabel("");
		lblUserNameTip.setForeground(new Color(220, 20, 60));
		lblUserNameTip.setBounds(351, 48, 140, 15);
		body.add(lblUserNameTip);

		lblPSWTip = new JLabel("");
		lblPSWTip.setForeground(new Color(220, 20, 60));
		lblPSWTip.setBounds(351, 90, 140, 15);
		body.add(lblPSWTip);

		txtPassWord =new JPasswordField();
		txtPassWord.setBounds(165, 87, 176, 32);
		body.add(txtPassWord);
		txtPassWord.setColumns(10);
	}

	/*
	 * 对用户登录信息从语法方面进行验证
	 */
	private boolean validateUser() {
		boolean result = true;

		if (txtUserName.getText().isEmpty()) {
			this.lblUserNameTip.setText("请输入用户名！");
			result = result && false;
		}
		if (new String(txtPassWord.getText()).isEmpty()) {
			this.lblPSWTip.setText("请输入密码!");
			result = result && false;
		}
		return result;
	}
}
