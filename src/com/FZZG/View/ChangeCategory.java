package com.FZZG.View;

import com.FZZG.DAO.categoryDAO;
import com.FZZG.Model.categoryinfo;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChangeCategory {

	private JFrame frame;
	private JTextField textField;
	private JTextField newCategoryField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeCategory window = new ChangeCategory();
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
	public ChangeCategory() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Add.class.getResource("/image/bill2.png")));
		frame.setTitle("\u4FEE\u6539\u6D88\u8D39\u4FE1\u606F");
		frame.setBounds(100, 100, 500, 642);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Slogan = new JLabel("\u8BF7\u8F93\u5165\u8981\u4FEE\u6539\u7684\u7C7B\u522B\uFF1A");
		Slogan.setFont(new Font("΢���ź� Light", Font.PLAIN, 22));
		Slogan.setBounds(24, 10, 403, 81);
		frame.getContentPane().add(Slogan);
		
		textField = new JTextField();
		textField.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(130, 78, 175, 33);
		frame.getContentPane().add(textField);
		
		JButton QueryButton = new JButton("\u67E5\u8BE2");
		QueryButton.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		QueryButton.setBounds(338, 78, 101, 33);
		QueryButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String category = textField.getText();
				ResultSet rs = categoryDAO.searchCategory(category);
				try {
					if (rs.next()) {
						JOptionPane.showMessageDialog(ChangeCategory.this.frame, "存在该类别");
					} else {
						JOptionPane.showMessageDialog(ChangeCategory.this.frame, "不存在该类别");
					}

				} catch (SQLException exc) {
					exc.printStackTrace();
				}
			}
		});

		frame.getContentPane().add(QueryButton);
		
		JSeparator UpSeparator = new JSeparator();
		UpSeparator.setBounds(10, 133, 476, 2);
		frame.getContentPane().add(UpSeparator);
		
		newCategoryField = new JTextField();
		newCategoryField.setColumns(10);
		newCategoryField.setBounds(189, 286, 208, 45);
		frame.getContentPane().add(newCategoryField);
		
		JLabel newCategoryLabel = new JLabel("\u65B0\u7C7B\u522B\uFF1A");
		newCategoryLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		newCategoryLabel.setFont(new Font("΢���ź�", Font.PLAIN, 22));
		newCategoryLabel.setBounds(23, 286, 143, 45);
		frame.getContentPane().add(newCategoryLabel);
		
		JSeparator DownSeparator = new JSeparator();
		DownSeparator.setBounds(10, 513, 476, 2);
		frame.getContentPane().add(DownSeparator);
		
		JButton ChangeButton = new JButton("\u4FEE\u6539");
		ChangeButton.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		ChangeButton.setBounds(189, 549, 101, 33);
		ChangeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String oldCategory = textField.getText();
				categoryinfo OldCategory = new categoryinfo(oldCategory);
				String newCategory = newCategoryField.getText();
				categoryinfo NewCategory = new categoryinfo(newCategory);
				int result = categoryDAO.updateCategory(OldCategory, NewCategory);
				if (result == 0) {
					JOptionPane.showMessageDialog(ChangeCategory.this.frame, "修改失败");
				} else {
					JOptionPane.showMessageDialog(ChangeCategory.this.frame, "修改成功");
				}

			}
		});
		frame.getContentPane().add(ChangeButton);
		
		JLabel AuthorLabel = new JLabel("By Group_FZZG");
		AuthorLabel.setBounds(10, 589, 119, 15);
		frame.getContentPane().add(AuthorLabel);
		frame.setVisible(true);
	}

}
