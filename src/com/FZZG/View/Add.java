package com.FZZG.View;

import com.FZZG.DAO.billinginfoDAO;
import com.FZZG.DAO.categoryDAO;
import com.FZZG.Model.billinginfo;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import static com.FZZG.DAO.categoryDAO.searchCategory;

public class Add {

	private JFrame frame;
	private JTextField itemField;
	private JTextField timeField;
	private JTextField priceField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add window = new Add();
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
	public Add() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Add.class.getResource("/image/bill2.png")));
		frame.setTitle("\u6DFB\u52A0\u4FE1\u606F");
		frame.setBounds(100, 100, 500, 642);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Slogan = new JLabel("\u8BF7\u8F93\u5165\u65B0\u6D88\u8D39\u4FE1\u606F\uFF1A");
		Slogan.setFont(new Font("΢���ź� Light", Font.PLAIN, 28));
		Slogan.setBounds(29, 29, 447, 81);
		frame.getContentPane().add(Slogan);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 120, 466, 2);
		frame.getContentPane().add(separator);
		
		JLabel AuthorLabel = new JLabel("By Group_FZZG");
		AuthorLabel.setBounds(10, 580, 119, 15);
		frame.getContentPane().add(AuthorLabel);
		
		itemField = new JTextField();
		itemField.setBounds(173, 198, 244, 39);
		frame.getContentPane().add(itemField);
		itemField.setColumns(10);
		
		timeField = new JTextField();
		timeField.setToolTipText("\u8BF7\u8F93\u5165\u6D88\u8D39\u65F6\u95F4");
		timeField.setColumns(10);
		timeField.setBounds(173, 254, 244, 39);
		frame.getContentPane().add(timeField);
		
		priceField = new JTextField();
		priceField.setColumns(10);
		priceField.setBounds(173, 312, 244, 39);
		frame.getContentPane().add(priceField);
		
		JLabel ItemLabel = new JLabel("\u7269\u54C1\uFF1A");
		ItemLabel.setFont(new Font("΢���ź�", Font.PLAIN, 21));
		ItemLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		ItemLabel.setBounds(71, 198, 92, 39);
		frame.getContentPane().add(ItemLabel);
		
		JLabel TimeLabel = new JLabel("\u6D88\u8D39\u65F6\u95F4\uFF1A");
		TimeLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		TimeLabel.setFont(new Font("΢���ź�", Font.PLAIN, 21));
		TimeLabel.setBounds(29, 254, 134, 39);
		frame.getContentPane().add(TimeLabel);
		
		JLabel PriceLabel = new JLabel("\u4EF7\u683C\uFF1A");
		PriceLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		PriceLabel.setFont(new Font("΢���ź�", Font.PLAIN, 21));
		PriceLabel.setBounds(71, 312, 92, 39);
		frame.getContentPane().add(PriceLabel);
		
		JLabel CategoryLabel = new JLabel("\u7C7B\u522B\uFF1A");
		CategoryLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		CategoryLabel.setFont(new Font("΢���ź�", Font.PLAIN, 21));
		CategoryLabel.setBounds(71, 370, 92, 39);
		frame.getContentPane().add(CategoryLabel);
		
		JComboBox Categories = new JComboBox();
		ResultSet rs = categoryDAO.searchCategory();
		try {
			while(rs.next()) {
				Categories.addItem(rs.getString("category"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Categories.setBounds(173, 376, 119, 30);
		frame.getContentPane().add(Categories);
		
		JButton SubmitButton = new JButton("\u63D0\u4EA4");
		SubmitButton.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		SubmitButton.setBounds(190, 515, 108, 30);
		SubmitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String item = itemField.getText();
				Date time = Date.valueOf(timeField.getText());
				Float prices = Float.valueOf(priceField.getText());
				String category = (String) Categories.getSelectedItem();
				billinginfo billing = new billinginfo(item, time, prices, category);
				billinginfoDAO.addBillinginfo(billing);
				JOptionPane.showMessageDialog(Add.this.frame, "添加成功");
			}
		});
		frame.getContentPane().add(SubmitButton);
		frame.setVisible(true);
	}

//	public static void main(String[] args) {
//		Add add = new Add();
//	}
}
