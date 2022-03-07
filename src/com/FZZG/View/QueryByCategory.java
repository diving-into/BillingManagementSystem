package com.FZZG.View;

import com.FZZG.DAO.billinginfoDAO;
import com.FZZG.DAO.categoryDAO;
import com.FZZG.Model.billinginfo;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class QueryByCategory {

	private JFrame frame;
	private JTable table;
	private DefaultTableModel defaultTableModel;
	private JScrollPane scrollPane = new JScrollPane();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QueryByCategory window = new QueryByCategory();
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
	public QueryByCategory() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("\u6309\u7C7B\u522B\u67E5\u8BE2\u6D88\u8D39\u4FE1\u606F");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(QueryByCategory.class.getResource("/image/bill2.png")));
		frame.setBounds(100, 100, 500, 642);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Slogan = new JLabel("\u8BF7\u9009\u62E9\u6D88\u8D39\u7C7B\u522B\uFF1A");
		Slogan.setFont(new Font("΢���ź� Light", Font.PLAIN, 28));
		Slogan.setBounds(39, 20, 224, 81);
		frame.getContentPane().add(Slogan);
		
		JSeparator UpSeparator = new JSeparator();
		UpSeparator.setBounds(10, 111, 476, 2);
		frame.getContentPane().add(UpSeparator);
		
		JComboBox comboBox = new JComboBox();
		ResultSet rs = categoryDAO.searchCategory();
		try {
			while(rs.next()) {
				comboBox.addItem(rs.getString("category"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		comboBox.setBounds(280, 38, 144, 41);
		frame.getContentPane().add(comboBox);
		
		JSeparator DownSeparator = new JSeparator();
		DownSeparator.setBounds(10, 523, 476, 2);
		frame.getContentPane().add(DownSeparator);
		
		JButton QueryButton = new JButton("\u67E5\u8BE2");
		QueryButton.setFont(new Font("΢���ź�", Font.PLAIN, 15));
		QueryButton.setBounds(186, 548, 101, 33);
		defaultTableModel = new DefaultTableModel();
		QueryButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				scrollPane.removeAll();
				defaultTableModel.setRowCount(0);
				frame.getContentPane().add(scrollPane);
				String category = (String)comboBox.getSelectedItem();
				ResultSet rs = billinginfoDAO.searchBillinginfoByCategory(category);
				String[] columnNames = new String[] { "item", "time", "prices", "category"};
				defaultTableModel.setColumnIdentifiers(columnNames);
				try {
					while (rs.next()) {
						Vector<String> v = new Vector<>(4);
						v.add(0, rs.getString("item"));
						v.add(1, rs.getString("time"));
						v.add(2, rs.getString("prices"));
						v.add(3, rs.getString("category"));
						defaultTableModel.addRow(v);
					}
				} catch (SQLException se) {
					se.printStackTrace();
				}
				table = new JTable(defaultTableModel);
				scrollPane = new JScrollPane(table);
				scrollPane.setBounds(10, 122, 476, 386);
				frame.getContentPane().add(scrollPane);
			}

		});
		frame.getContentPane().add(QueryButton);
		frame.setVisible(true);

	}

}
