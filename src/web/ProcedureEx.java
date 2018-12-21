package web;

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
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ProcedureEx extends JFrame {

	private JPanel contentPane;
	private JSplitPane splitPane;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JTextArea ta;
	private JLabel lblNewLabel;
	private JTextField tfNum;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JTextField tfName;
	private JTextField tfEmail;
	private JTextField tfAddr;
	private JTextField tfPhone;
	private JButton btnIn;
	private JButton btnView;
	 String url,id,pwd;
	 private JTextField tfSearch;
	 private JComboBox cb;
	 private JButton btnNewButton;
	  
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProcedureEx frame = new ProcedureEx();
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
	public ProcedureEx() {
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
		setBounds(100, 100, 677, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getSplitPane(), BorderLayout.CENTER);
	}

	private JSplitPane getSplitPane() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setRightComponent(getScrollPane());
			splitPane.setLeftComponent(getPanel());
			splitPane.setDividerLocation(350);
		}
		return splitPane;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTa());
		}
		return scrollPane;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setLayout(null);
			panel.add(getLblNewLabel());
			panel.add(getTfNum());
			panel.add(getLabel());
			panel.add(getLabel_1());
			panel.add(getLabel_2());
			panel.add(getLabel_3());
			panel.add(getTfName());
			panel.add(getTfEmail());
			panel.add(getTfAddr());
			panel.add(getTfPhone());
			panel.add(getBtnIn());
			panel.add(getBtnView());
			panel.add(getTfSearch());
			panel.add(getCb());
			panel.add(getBtnNewButton());
		}
		return panel;
	}
	private JTextArea getTa() {
		if (ta == null) {
			ta = new JTextArea();
		}
		return ta;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uBC88\uD638");
			lblNewLabel.setFont(new Font("나눔스퀘어라운드 Bold", Font.BOLD, 15));
			lblNewLabel.setBounds(23, 66, 57, 18);
		}
		return lblNewLabel;
	}
	private JTextField getTfNum() {
		if (tfNum == null) {
			tfNum = new JTextField();
			tfNum.setBounds(103, 62, 116, 27);
			tfNum.setColumns(10);
		}
		return tfNum;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("\uC774\uB984");
			label.setFont(new Font("나눔스퀘어라운드 Bold", Font.BOLD, 15));
			label.setBounds(23, 115, 57, 18);
		}
		return label;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("\uC774\uBA54\uC77C");
			label_1.setFont(new Font("나눔스퀘어라운드 Bold", Font.BOLD, 15));
			label_1.setBounds(23, 166, 57, 18);
		}
		return label_1;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("\uC8FC\uC18C");
			label_2.setFont(new Font("나눔스퀘어라운드 Bold", Font.BOLD, 15));
			label_2.setBounds(23, 222, 57, 18);
		}
		return label_2;
	}
	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("\uC804\uD654\uBC88\uD638");
			label_3.setFont(new Font("나눔스퀘어라운드 Bold", Font.BOLD, 15));
			label_3.setBounds(23, 275, 57, 18);
		}
		return label_3;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setColumns(10);
			tfName.setBounds(103, 114, 187, 27);
		}
		return tfName;
	}
	private JTextField getTfEmail() {
		if (tfEmail == null) {
			tfEmail = new JTextField();
			tfEmail.setColumns(10);
			tfEmail.setBounds(103, 165, 187, 27);
		}
		return tfEmail;
	}
	private JTextField getTfAddr() {
		if (tfAddr == null) {
			tfAddr = new JTextField();
			tfAddr.setColumns(10);
			tfAddr.setBounds(103, 221, 187, 27);
		}
		return tfAddr;
	}
	private JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setColumns(10);
			tfPhone.setBounds(103, 274, 166, 27);
		}
		return tfPhone;
	}
	private JButton getBtnIn() {
		if (btnIn == null) {
			btnIn = new JButton("\uCD94\uAC00");
			btnIn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					 try {
				         Connection con = DriverManager.getConnection(url, id, pwd);
				         String sql ="{call test_procedure(?,?,?,?,?)}";
				         CallableStatement cs = con.prepareCall(sql);
				         cs.setInt(1,Integer.parseInt(tfNum.getText()) );
				         cs.setString(2, tfName.getText());
				         cs.setString(3, tfEmail.getText());
				         cs.setString(4, tfAddr.getText());
				         cs.setString(5, tfPhone.getText());
				         cs.executeUpdate();
				         
				      } catch (SQLException e) {
				         // TODO 자동 생성된 catch 블록
				         e.printStackTrace();
				      }
					 tfNum.setText("");
					 tfName.setText("");
					 tfEmail.setText("");
					 tfAddr.setText("");
					 tfPhone.setText("");
				}
			});
			btnIn.setBackground(Color.WHITE);
			btnIn.setFont(new Font("나눔스퀘어라운드 Bold", Font.BOLD, 15));
			btnIn.setBounds(23, 325, 116, 27);
		}
		return btnIn;
	}
	private JButton getBtnView() {
		if (btnView == null) {
			btnView = new JButton("\uC804\uCCB4\uBCF4\uAE30");
			btnView.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
		
						   try {
							Connection con = DriverManager.getConnection(url, id, pwd);
							String sql ="{?=call allView2()}";
							CallableStatement cs = con.prepareCall(sql);
							cs.registerOutParameter(1,OracleTypes.CURSOR);
							cs.executeQuery();
							ResultSet rs = (ResultSet)cs.getObject(1);//cursor는 오브젝트형이기떄문에 rs형으로 바꾸어주어야함.
							while(rs.next()) {
								ta.append("번호:"+ rs.getString("num")+"\n");
								ta.append("이름:"+ rs.getString("ename")+"\n");
								ta.append("이메일:"+ rs.getString("email")+"\n");
								ta.append("주소:"+ rs.getString("addr")+"\n");
								ta.append("폰:"+ rs.getString("phone")+"\n"+"\n");
							}
						   } catch (SQLException a) {
							// TODO Auto-generated catch block
							a.printStackTrace();
						}
						   
					   }
				
			});
			btnView.setBackground(Color.WHITE);
			btnView.setFont(new Font("나눔스퀘어라운드 Bold", Font.BOLD, 15));
			btnView.setBounds(174, 325, 116, 27);
		}
		return btnView;
	}
	private JTextField getTfSearch() {
		if (tfSearch == null) {
			tfSearch = new JTextField();
			tfSearch.setBounds(126, 376, 116, 21);
			tfSearch.setColumns(10);
		}
		return tfSearch;
	}
	private JComboBox getCb() {
		if (cb == null) {
			cb = new JComboBox();
			cb.setModel(new DefaultComboBoxModel(new String[] {"\uBC88\uD638", "\uC774\uB984"}));
			cb.setBounds(23, 376, 91, 21);
		}
		return cb;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("\uAC80\uC0C9");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(cb.getSelectedItem()=="번호"){
						   try {
								Connection con = DriverManager.getConnection(url, id, pwd);
								String sql ="{?=call num_view(?)}";
								
								CallableStatement cs = con.prepareCall(sql);
								cs.setInt(2, Integer.parseInt(tfSearch.getText()));
								cs.registerOutParameter(1,OracleTypes.CURSOR);
								cs.executeQuery();
								ResultSet rs = (ResultSet)cs.getObject(1);//cursor는 오브젝트형이기떄문에 rs형으로 바꾸어주어야함.
								while(rs.next()) {
									ta.append("번호:"+ rs.getString("num")+"\n");
									ta.append("이름:"+ rs.getString("ename")+"\n");
									ta.append("이메일:"+ rs.getString("email")+"\n");
									ta.append("주소:"+ rs.getString("addr")+"\n");
									ta.append("폰:"+ rs.getString("phone")+"\n"+"\n");
								}
							   } catch (SQLException a) {
								// TODO Auto-generated catch block
								a.printStackTrace();
							}
							   
						
					}else{
						   try {
								Connection con = DriverManager.getConnection(url, id, pwd);
								String sql ="{?=call name_view(?)}";
								
								CallableStatement cs = con.prepareCall(sql);
								cs.setString(2, tfSearch.getText());
								cs.registerOutParameter(1,OracleTypes.CURSOR);
								cs.executeQuery();
								ResultSet rs = (ResultSet)cs.getObject(1);//cursor는 오브젝트형이기떄문에 rs형으로 바꾸어주어야함.
								while(rs.next()) {
									ta.append("번호:"+ rs.getString("num")+"\n");
									ta.append("이름:"+ rs.getString("ename")+"\n");
									ta.append("이메일:"+ rs.getString("email")+"\n");
									ta.append("주소:"+ rs.getString("addr")+"\n");
									ta.append("폰:"+ rs.getString("phone")+"\n"+"\n");
								}
							   } catch (SQLException a) {
								// TODO Auto-generated catch block
								a.printStackTrace();
							}
					}
				}
			});
			btnNewButton.setFont(new Font("나눔스퀘어라운드 Bold", Font.BOLD, 15));
			btnNewButton.setBounds(254, 371, 83, 27);
		}
		return btnNewButton;
	}
}
