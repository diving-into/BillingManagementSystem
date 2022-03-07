package com.FZZG.View;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class QueryByTime {

	private JFrame frame;
	private JTextField Year;
	private JTextField Month;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueryByTime window = new QueryByTime();
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
	public QueryByTime() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("\u6309\u65F6\u95F4\u67E5\u8BE2\u6D88\u8D39\u4FE1\u606F");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(QueryByCategory.class.getResource("/image/bill2.png")));
		frame.setBounds(100, 100, 500, 642);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Slogan = new JLabel("\u8BF7\u8F93\u5165\u6D88\u8D39\u65F6\u95F4\uFF1A");
		Slogan.setFont(new Font("΢���ź� Light", Font.PLAIN, 28));
		Slogan.setBounds(39, 10, 224, 81);
		frame.getContentPane().add(Slogan);
		
		JSeparator UpSeparator = new JSeparator();
		UpSeparator.setBounds(10, 101, 476, 2);
		frame.getContentPane().add(UpSeparator);
		
		Year = new JTextField();
		Year.setBounds(327, 24, 114, 31);
		frame.getContentPane().add(Year);
		Year.setColumns(10);
		
		Month = new JTextField();
		Month.setColumns(10);
		Month.setBounds(327, 60, 114, 31);
		frame.getContentPane().add(Month);
		
		JLabel YearLabel = new JLabel("\u5E74\u4EFD\uFF1A");
		YearLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		YearLabel.setBounds(259, 32, 58, 15);
		frame.getContentPane().add(YearLabel);
		
		JLabel MonthLabel = new JLabel("\u6708\u4EFD\uFF1A");
		MonthLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		MonthLabel.setBounds(259, 68, 58, 15);
		frame.getContentPane().add(MonthLabel);
		
		JSeparator DownSeparator = new JSeparator();
		DownSeparator.setBounds(10, 529, 476, 2);
		frame.getContentPane().add(DownSeparator);
		
		JButton QueryButton = new JButton("\u67E5\u8BE2");
		QueryButton.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		QueryButton.setBounds(186, 554, 101, 33);
		frame.getContentPane().add(QueryButton);
		
		JLabel AuthorLabel = new JLabel("By Group_FZZG");
		AuthorLabel.setBounds(10, 589, 119, 15);
		frame.getContentPane().add(AuthorLabel);
	}
}
