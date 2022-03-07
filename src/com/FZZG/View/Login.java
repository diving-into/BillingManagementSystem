package com.FZZG.View;

import com.FZZG.Model.userinfo;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Toolkit;
import java.awt.Font;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Objects;

import com.FZZG.DAO.*;


public class Login {

	private JFrame frame;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u767B\u5F55\u5230\u7CFB\u7EDF");
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/image/bill2.png")));
		frame.getContentPane().setEnabled(false);
		frame.getContentPane().setLayout(null);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("΢���ź�", Font.PLAIN, 25));
		usernameField.setBounds(247, 115, 272, 32);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("΢���ź�", Font.PLAIN, 25));
		passwordField.setBounds(247, 169, 272, 32);
		frame.getContentPane().add(passwordField);
		
		JLabel Slogan = new JLabel("\u767B\u5F55");
		Slogan.setFont(new Font("����", Font.PLAIN, 40));
		Slogan.setHorizontalAlignment(SwingConstants.CENTER);
		Slogan.setBounds(10, 28, 595, 42);
		frame.getContentPane().add(Slogan);

		
		JButton RegisterButton = new JButton("\u6CE8\u518C\u65B0\u7528\u6237");
		RegisterButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Registration();
			}
		});
		RegisterButton.setFont(new Font("΢���ź� Light", Font.PLAIN, 13));
		RegisterButton.setBounds(415, 243, 104, 32);
		frame.getContentPane().add(RegisterButton);
		
		JLabel UserNameLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		UserNameLabel.setIcon(new ImageIcon(Login.class.getResource("/image/username.png")));
		UserNameLabel.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		UserNameLabel.setBounds(72, 117, 165, 32);
		frame.getContentPane().add(UserNameLabel);
		
		JLabel PasswordLabel = new JLabel("\u5BC6\u7801\uFF1A");
		PasswordLabel.setIcon(new ImageIcon(Login.class.getResource("/image/password.png")));
		PasswordLabel.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		PasswordLabel.setBounds(72, 169, 165, 32);
		frame.getContentPane().add(PasswordLabel);
		
		JLabel AuthorLabel = new JLabel("By Group_FZZG");
		AuthorLabel.setBounds(10, 324, 119, 15);
		frame.getContentPane().add(AuthorLabel);
		
		JRadioButton AdminSelectButton = new JRadioButton("\u7BA1\u7406\u5458");
		buttonGroup.add(AdminSelectButton);
		AdminSelectButton.setBounds(82, 228, 127, 23);
		frame.getContentPane().add(AdminSelectButton);
		
		JRadioButton UserSelectButton = new JRadioButton("\u666E\u901A\u7528\u6237");
		buttonGroup.add(UserSelectButton);
		UserSelectButton.setSelected(true);
		UserSelectButton.setBounds(82, 265, 127, 23);
		frame.getContentPane().add(UserSelectButton);


		JButton LoginButton = new JButton("\u767B\u5F55");
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				String password = String.valueOf(passwordField.getPassword());
				String trueUsername;
				String truePassword;
				int ifAdmin;
				userinfo user = userinfoDAO.Login(username);
				Boolean adminSelected = AdminSelectButton.isSelected();

				trueUsername = user.getUsername();
				truePassword = user.getPassword();
				ifAdmin = user.getIfAdmin();
				if (Objects.equals(truePassword, password)) {
					if (ifAdmin == 1 && adminSelected) {
						JOptionPane.showMessageDialog(Login.this.frame, "登录成功，您的身份为管理员");
						new Main(ifAdmin);
					}
					else if (ifAdmin==0 && !adminSelected){
						JOptionPane.showMessageDialog(Login.this.frame,"登录成功，您的身份为访客");
						new Main(ifAdmin);
					}
					else if (ifAdmin == 0 && adminSelected){
						JOptionPane.showMessageDialog(Login.this.frame,"身份选择错误");
					} else {
						JOptionPane.showMessageDialog(Login.this.frame,"身份选择错误");
					}
				}
				else {
					JOptionPane.showMessageDialog(Login.this.frame,"用户名或密码不正确！");
				}
			}
		});

		LoginButton.setFont(new Font("΢���ź� Light", Font.PLAIN, 20));
		LoginButton.setBounds(247, 243, 104, 32);
		frame.getContentPane().add(LoginButton);

		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 80, 595, 2);
		frame.getContentPane().add(separator);
		frame.setBounds(100, 100, 619, 377);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
