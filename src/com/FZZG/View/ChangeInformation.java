package com.FZZG.View;

import com.FZZG.DAO.billinginfoDAO;
import com.FZZG.DAO.categoryDAO;
import com.FZZG.Model.billinginfo;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.management.Query;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChangeInformation {

	private JFrame frame;
	private JTextField searchField;
	private JTextField ItemTextField;
	private JTextField priceField;
	private JTextField timeField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeInformation window = new ChangeInformation();
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
	public ChangeInformation() {
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
		
		JLabel Slogan = new JLabel("\u8BF7\u8F93\u5165\u8981\u4FEE\u6539\u4FE1\u606F\u7684\u7269\u54C1\u6216\u4EF7\u683C\uFF1A");
		Slogan.setFont(new Font("΢���ź� Light", Font.PLAIN, 22));
		Slogan.setBounds(24, 10, 403, 81);
		frame.getContentPane().add(Slogan);
		
		JSeparator UpSeparator = new JSeparator();
		UpSeparator.setBounds(10, 133, 476, 2);
		frame.getContentPane().add(UpSeparator);
		
		JSeparator DownSeparator = new JSeparator();
		DownSeparator.setBounds(10, 513, 476, 2);
		frame.getContentPane().add(DownSeparator);

		searchField = new JTextField();
		searchField.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		searchField.setBounds(130, 78, 175, 33);
		frame.getContentPane().add(searchField);
		searchField.setColumns(10);

		JButton QueryButton = new JButton("\u67E5\u8BE2");
		QueryButton.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		QueryButton.setBounds(338, 78, 101, 33);
		QueryButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String item = searchField.getText();
				ResultSet rs = billinginfoDAO.searchBillinginfo(item);
				try {
					if (rs.next()) {
						JOptionPane.showMessageDialog(ChangeInformation.this.frame, "存在该物品");
					} else {
						JOptionPane.showMessageDialog(ChangeInformation.this.frame, "不存在该物品");
					}

				} catch (SQLException exc) {
					exc.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(QueryButton);
		
		ItemTextField = new JTextField();
		ItemTextField.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		ItemTextField.setColumns(10);
		ItemTextField.setBounds(190, 186, 208, 45);
		frame.getContentPane().add(ItemTextField);
		
		JLabel ItemLabel = new JLabel("\u7269\u54C1\uFF1A");
		ItemLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		ItemLabel.setFont(new Font("΢���ź�", Font.PLAIN, 22));
		ItemLabel.setBounds(24, 186, 143, 45);
		frame.getContentPane().add(ItemLabel);
		
		priceField = new JTextField();
		priceField.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		priceField.setColumns(10);
		priceField.setBounds(190, 265, 208, 45);
		frame.getContentPane().add(priceField);
		
		JLabel PriceLabel = new JLabel("\u4EF7\u683C\uFF1A");
		PriceLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		PriceLabel.setFont(new Font("΢���ź�", Font.PLAIN, 22));
		PriceLabel.setBounds(24, 265, 143, 45);
		frame.getContentPane().add(PriceLabel);
		
		timeField = new JTextField();
		timeField.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		timeField.setColumns(10);
		timeField.setBounds(190, 338, 208, 45);
		frame.getContentPane().add(timeField);
		
		JLabel TimeLabel = new JLabel("\u65F6\u95F4\uFF1A");
		TimeLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		TimeLabel.setFont(new Font("΢���ź�", Font.PLAIN, 22));
		TimeLabel.setBounds(24, 338, 143, 45);
		frame.getContentPane().add(TimeLabel);
		
		JLabel CategoryLabel = new JLabel("\u7C7B\u522B\uFF1A");
		CategoryLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		CategoryLabel.setFont(new Font("΢���ź�", Font.PLAIN, 22));
		CategoryLabel.setBounds(24, 412, 143, 45);
		frame.getContentPane().add(CategoryLabel);
		
		JComboBox comboBox = new JComboBox();
		ResultSet rs = categoryDAO.searchCategory();
		try {
			while(rs.next()) {
				comboBox.addItem(rs.getString("category"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		comboBox.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		comboBox.setBounds(189, 417, 116, 45);
		frame.getContentPane().add(comboBox);
		
		JLabel timeFormatLabel = new JLabel("yyyy-MM-DD");
		timeFormatLabel.setBounds(90, 387, 77, 15);
		frame.getContentPane().add(timeFormatLabel);
		
		JLabel AuthorLabel = new JLabel("By Group_FZZG");
		AuthorLabel.setBounds(10, 589, 119, 15);
		frame.getContentPane().add(AuthorLabel);
		frame.setVisible(true);

		JButton ChangeButton = new JButton("\u4FEE\u6539");
		ChangeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String oldItem = searchField.getText();
				String newItem = ItemTextField.getText();
				Date time = Date.valueOf(timeField.getText());
				Float prices = Float.valueOf(priceField.getText());
				String category = (String) comboBox.getSelectedItem();
				billinginfo billing = new billinginfo(newItem, time, prices, category);
				billinginfoDAO.updateBillinginfo(billing, oldItem);
				JOptionPane.showMessageDialog(ChangeInformation.this.frame, "修改成功");
			}
		});
		ChangeButton.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		ChangeButton.setBounds(189, 549, 101, 33);
		frame.getContentPane().add(ChangeButton);
		frame.setVisible(true);
	}
}
