package com.FZZG.View;

import com.FZZG.Model.userinfo;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.FZZG.DAO.userinfoDAO;

public class Registration {

	private JFrame frame;
	private JTextField UserNameField;
	private JPasswordField passwordField;
	private JPasswordField passwordCheckField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
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
	public Registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Registration.class.getResource("/image/login.png")));
		frame.setTitle("\u6CE8\u518C\u65B0\u7528\u6237");
		frame.setResizable(false);
		frame.setBounds(100, 100, 463, 575);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Slogan = new JLabel("\u8BF7\u8F93\u5165\u65B0\u7528\u6237\u4FE1\u606F\uFF1A");
		Slogan.setFont(new Font("微锟斤拷锟脚猴拷 Light", Font.PLAIN, 27));
		Slogan.setBounds(29, 34, 420, 81);
		frame.getContentPane().add(Slogan);
		
		UserNameField = new JTextField();
		UserNameField.setBounds(158, 171, 246, 32);
		frame.getContentPane().add(UserNameField);
		UserNameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(158, 236, 246, 32);
		frame.getContentPane().add(passwordField);
		
		passwordCheckField = new JPasswordField();
		passwordCheckField.setBounds(158, 308, 246, 32);
		frame.getContentPane().add(passwordCheckField);
		
		JLabel UserNameLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		UserNameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		UserNameLabel.setFont(new Font("微锟斤拷锟脚猴拷", Font.PLAIN, 20));
		UserNameLabel.setBounds(58, 160, 90, 44);
		frame.getContentPane().add(UserNameLabel);
		
		JLabel PasswordLabel = new JLabel("\u5BC6\u7801\uFF1A");
		PasswordLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		PasswordLabel.setFont(new Font("微锟斤拷锟脚猴拷", Font.PLAIN, 20));
		PasswordLabel.setBounds(58, 236, 90, 33);
		frame.getContentPane().add(PasswordLabel);
		
		JLabel PasswordCheckLabel = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		PasswordCheckLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		PasswordCheckLabel.setFont(new Font("微锟斤拷锟脚猴拷", Font.PLAIN, 20));
		PasswordCheckLabel.setBounds(29, 297, 120, 44);
		frame.getContentPane().add(PasswordCheckLabel);
		
		JLabel PasswordTipLabel = new JLabel("\uFF086~18浣嶅瓧姣嶆垨鏁板瓧,涓嬪垝绾縗\uFF09");
		PasswordTipLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PasswordTipLabel.setBounds(58, 272, 140, 15);
		frame.getContentPane().add(PasswordTipLabel);

		JLabel UsernameTipLabel = new JLabel("锛堝彧鑳藉寘鍚ぇ灏忓啓瀛楁瘝锛屾暟瀛楁垨涓嬪垝绾匡級");
		UsernameTipLabel.setHorizontalAlignment(SwingConstants.CENTER);
		UsernameTipLabel.setBounds(58,212,240,15);
		frame.getContentPane().add(UsernameTipLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 125, 439, 2);
		frame.getContentPane().add(separator);
		
		JCheckBox AdminCheckBox = new JCheckBox("\u6CE8\u518C\u4E3A\u7BA1\u7406\u5458");
		AdminCheckBox.setBounds(178, 470, 109, 23);
		frame.getContentPane().add(AdminCheckBox);
		
		JButton SubmitButton = new JButton("\u63D0\u4EA4");
		SubmitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = UserNameField.getText();
				String password = String.valueOf(passwordField.getPassword());
				String passwordCheck = String.valueOf(passwordCheckField.getPassword());
				Boolean adminSelected = AdminCheckBox.isSelected();
				Pattern usernamePatter = Pattern.compile("[A-Za-z0-9]*");
				Pattern passwordPattern = Pattern.compile("[A-Za-z0-9]{5,17}");
				Matcher ifPasswordMatch = passwordPattern.matcher(password);
				Matcher ifUsernameMatch = usernamePatter.matcher(username);
				String adminPassword;

				if (!ifUsernameMatch.matches()||!ifPasswordMatch.matches()){
					JOptionPane.showMessageDialog(Registration.this.frame,"用户名或密码格式错误");
					JOptionPane.showMessageDialog(Registration.this.frame,username+"+"+password);
				}
				else{
					if (!password.equals(passwordCheck)){
						JOptionPane.showMessageDialog(Registration.this.frame,"两次输入的密码不一致");
					}
					else {
						if(adminSelected){
							adminPassword = JOptionPane.showInputDialog(Registration.this.frame,"请输入管理员口令");
							if (Objects.equals(adminPassword, "I am admin")){
								userinfo user = new userinfo(username, password, 1);
								userinfoDAO.Register(user);
								JOptionPane.showMessageDialog(Registration.this.frame,"管理员注册成功");
							}
							else {
								JOptionPane.showMessageDialog(Registration.this.frame,"管理员口令不正确");
							}
						}
						else {
							userinfo user = new userinfo(username, password, 0);
							userinfoDAO.Register(user);
							JOptionPane.showMessageDialog(Registration.this.frame,"您已经成功注册为普通用户");
						}
					}
				}

				
				
				
			}
		});
		SubmitButton.setFont(new Font("微锟斤拷锟脚猴拷", Font.PLAIN, 16));
		SubmitButton.setBounds(168, 432, 109, 32);
		frame.getContentPane().add(SubmitButton);
		
		JLabel AuthorLabel = new JLabel("By Group_FZZG");
		AuthorLabel.setBounds(10, 522, 119, 15);
		frame.getContentPane().add(AuthorLabel);
		frame.setVisible(true);
	}
}
