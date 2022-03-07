package com.FZZG.View;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class Delete {

	private JFrame frame;
	private JTextField searchField;
	private JTextField itemField;
	private JTextField priceField;
	private JTextField timeField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete window = new Delete();
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
	public Delete() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("\u5220\u9664\u6D88\u8D39\u4FE1\u606F");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(QueryByCategory.class.getResource("/image/bill2.png")));
		frame.setBounds(100, 100, 500, 642);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Slogan = new JLabel("\u8BF7\u8F93\u5165\u8981\u5220\u9664\u4FE1\u606F\u7684\u7269\u54C1\u6216\u4EF7\u683C\uFF1A");
		Slogan.setFont(new Font("΢���ź� Light", Font.PLAIN, 22));
		Slogan.setBounds(24, 10, 403, 81);
		frame.getContentPane().add(Slogan);
		
		JSeparator UpSeparator = new JSeparator();
		UpSeparator.setBounds(10, 133, 476, 2);
		frame.getContentPane().add(UpSeparator);
		
		JSeparator DownSeparator = new JSeparator();
		DownSeparator.setBounds(10, 513, 476, 2);
		frame.getContentPane().add(DownSeparator);
		
		JButton QueryButton = new JButton("\u67E5\u8BE2");
		QueryButton.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		QueryButton.setBounds(338, 78, 101, 33);
		frame.getContentPane().add(QueryButton);
		
		searchField = new JTextField();
		searchField.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		searchField.setColumns(10);
		searchField.setBounds(130, 78, 175, 33);
		frame.getContentPane().add(searchField);
		
		JButton ChangeButton = new JButton("\u5220\u9664");
		ChangeButton.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		ChangeButton.setBounds(189, 549, 101, 33);
		frame.getContentPane().add(ChangeButton);
		
		itemField = new JTextField();
		itemField.setEditable(false);
		itemField.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		itemField.setColumns(10);
		itemField.setBounds(190, 186, 208, 45);
		frame.getContentPane().add(itemField);
		
		JLabel ItemLabel = new JLabel("\u7269\u54C1\uFF1A");
		ItemLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		ItemLabel.setFont(new Font("΢���ź�", Font.PLAIN, 22));
		ItemLabel.setBounds(24, 186, 143, 45);
		frame.getContentPane().add(ItemLabel);
		
		priceField = new JTextField();
		priceField.setEditable(false);
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
		timeField.setEditable(false);
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
		
		JComboBox categoryCombobox = new JComboBox();
		categoryCombobox.setEnabled(false);
		categoryCombobox.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		categoryCombobox.setBounds(189, 417, 116, 45);
		frame.getContentPane().add(categoryCombobox);
		
		JLabel AuthorLabel = new JLabel("By Group_FZZG");
		AuthorLabel.setBounds(10, 589, 119, 15);
		frame.getContentPane().add(AuthorLabel);
	}

}
