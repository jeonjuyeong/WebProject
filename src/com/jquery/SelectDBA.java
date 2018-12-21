package com.jquery;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import oracle.jdbc.internal.OracleTypes;

import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class SelectDBA extends JFrame {

	private JPanel contentPane;
	private JSplitPane splitPane;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTextArea ta;
	private JLabel label;
	private JTextField tf;
	private JButton btn;

	 String url,id,pwd;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectDBA frame = new SelectDBA();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SelectDBA() {
		   try {
		         Class.forName("oracle.jdbc.driver.OracleDriver");
		         url ="jdbc:oracle:thin:@localhost:1521:xe";
		         id = "scott";
		         pwd = "TIGER";
		      } 
		      catch (ClassNotFoundException e) {
		         e.printStackTrace();
		      }
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getSplitPane(), BorderLayout.CENTER);
	}

	private JSplitPane getSplitPane() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setDividerSize(2);
			splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPane.setLeftComponent(getPanel());
			splitPane.setRightComponent(getScrollPane());
			splitPane.setDividerLocation(60);
		}
		return splitPane;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(null);
			panel.add(getLabel());
			panel.add(getTf());
			panel.add(getBtn());
		}
		return panel;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTa());
		}
		return scrollPane;
	}
	private JTextArea getTa() {
		if (ta == null) {
			ta = new JTextArea();
		}
		return ta;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uBD80\uC11C\uBC88\uD638");
			label.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå ExtraBold", Font.BOLD, 16));
			label.setBounds(72, 21, 71, 26);
		}
		return label;
	}
	private JTextField getTf() {
		if (tf == null) {
			tf = new JTextField();
			tf.setFont(new Font("³ª´®¹Ù¸¥Ææ", Font.BOLD, 16));
			tf.setBounds(155, 23, 155, 24);
			tf.setColumns(10);
		}
		return tf;
	}
	private JButton getBtn() {
		if (btn == null) {
			btn = new JButton("\uD655\uC778");
			btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int num = Integer.parseInt(tf.getText());
					 try {
							Connection con = DriverManager.getConnection(url, id, pwd);
							String sql = "{?=call get_emp(?)}";
							CallableStatement cs = con.prepareCall(sql);
							cs.setInt(2, num);
							cs.registerOutParameter(1,OracleTypes.CURSOR);
							cs.executeQuery();
							ResultSet rs = (ResultSet)cs.getObject(1);
							while(rs.next()) {
							ta.append("ÀÌ¸§:"+ rs.getString(1)+"\n");
								ta.append("±Þ¿©:"+ rs.getInt("sal")+"\n");
								ta.append("\n");
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
			});
			btn.setFont(new Font("³ª´®½ºÄù¾î¶ó¿îµå ExtraBold", Font.BOLD, 16));
			btn.setBounds(336, 21, 81, 25);
		}
		return btn;
	}
}
