package com.FZZG.View;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public Main(int admin) {
		initialize(admin);

	}
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Main window = new Main();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int ifAdmin) {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/image/bill2.png")));
		frame.setTitle("\u8D26\u5355\u7BA1\u7406\u7CFB\u7EDF");
		frame.setBounds(100, 100, 500, 642);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Slogan = new JLabel("\u8D26\u5355\u7BA1\u7406\u7CFB\u7EDF");
		Slogan.setFont(new Font("Adobe 锟斤拷锟斤拷 Std L", Font.ITALIC, 41));
		Slogan.setHorizontalAlignment(SwingConstants.CENTER);
		Slogan.setBounds(10, 35, 476, 83);
		frame.getContentPane().add(Slogan);
		
		JLabel Version = new JLabel("Version 1.0");
		Version.setBounds(416, 103, 70, 15);
		frame.getContentPane().add(Version);
		
		JButton addButton = new JButton("\u6DFB\u52A0\u6D88\u8D39\u8BB0\u5F55");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//锟斤拷锟斤拷锟斤拷锟斤拷锟较�
				Add window = new Add();
			}
		});
		addButton.setFont(new Font("微锟斤拷锟脚猴拷", Font.PLAIN, 20));
		addButton.setBounds(60, 210, 162, 37);
		frame.getContentPane().add(addButton);
		
		JButton queryByTimeButton = new JButton("\u6309\u65F6\u95F4\u67E5\u8BE2");
		queryByTimeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//锟斤拷时锟斤拷锟窖�
				
				
				
				
			}
		});
		queryByTimeButton.setFont(new Font("微锟斤拷锟脚猴拷", Font.PLAIN, 21));
		queryByTimeButton.setBounds(181, 296, 142, 37);
		frame.getContentPane().add(queryByTimeButton);
		
		JButton queryByCategoryButton = new JButton("\u6309\u7C7B\u522B\u67E5\u8BE2");
		queryByCategoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//锟斤拷锟斤拷锟斤拷询
				
				
				
				
				
			}
		});
		queryByCategoryButton.setFont(new Font("微锟斤拷锟脚猴拷", Font.PLAIN, 20));
		queryByCategoryButton.setBounds(181, 389, 142, 37);
		frame.getContentPane().add(queryByCategoryButton);
		
		JButton changeButton = new JButton("\u4FEE\u6539\u6D88\u8D39\u4FE1\u606F");
		changeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//锟睫革拷锟斤拷锟斤拷锟斤拷息
				
				
				
				
				
			}
		});
		changeButton.setFont(new Font("微锟斤拷锟脚猴拷", Font.PLAIN, 20));
		changeButton.setBounds(53, 487, 169, 44);
		frame.getContentPane().add(changeButton);
		
		JButton changeCategoryButton = new JButton("\u4FEE\u6539\u6D88\u8D39\u7C7B\u522B");
		changeCategoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//锟睫革拷锟斤拷锟斤拷锟斤拷锟�
				ChangeCategory changeCategory = new ChangeCategory();
			}
		});
		changeCategoryButton.setFont(new Font("微锟斤拷锟脚猴拷", Font.PLAIN, 20));
		changeCategoryButton.setBounds(276, 487, 169, 44);
		frame.getContentPane().add(changeCategoryButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 116, 476, 2);
		frame.getContentPane().add(separator);
		
		JLabel AuthorLabel = new JLabel("By Group_FZZG");
		AuthorLabel.setBounds(10, 580, 119, 15);
		frame.getContentPane().add(AuthorLabel);
		
		JButton deleteButton = new JButton("\u5220\u9664\u6D88\u8D39\u8BB0\u5F55");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//删锟斤拷锟斤拷锟斤拷锟斤拷息
				
				
				
				
			}
		});

		deleteButton.setFont(new Font("微锟斤拷锟脚猴拷", Font.PLAIN, 20));
		deleteButton.setBounds(276, 210, 162, 37);
		if (ifAdmin==1)
			deleteButton.setEnabled(true);
		else
			deleteButton.setEnabled(false);
		frame.getContentPane().add(deleteButton);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		Main main = new Main(1);
	}
}
