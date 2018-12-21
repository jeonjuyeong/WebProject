package com.jquery;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.internal.OracleTypes;

public class InsertTest {
	   Scanner sc = new Scanner(System.in);
   String url,id,pwd;
   public InsertTest() {
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         url ="jdbc:oracle:thin:@localhost:1521:xe";
         id = "scott";
         pwd = "TIGER";
      } 
      catch (ClassNotFoundException e) {
         e.printStackTrace();
      }
   }
   public void printAvg() {
	   System.out.println("�μ���ȣ:");
	   int deptno =sc.nextInt();
	   try {
		Connection con = DriverManager.getConnection(url, id, pwd);
	     String sql ="{?=call getAVG(?)}";
         CallableStatement cs = con.prepareCall(sql);
         cs.setInt(2, deptno);
         cs.registerOutParameter(1, java.sql.Types.INTEGER);
         cs.execute();
         int avg=cs.getInt(1);
         System.out.println("��ձ޿�:"+avg);
	   } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   }
   }
   public void printDname() {
	   System.out.println("�����ȣ�Է�>>");
	   int empno =sc.nextInt();
	   try {
		Connection con = DriverManager.getConnection(url, id, pwd);
		String sql = "{?=call dname(?)}";
		CallableStatement cs = con.prepareCall(sql);
		cs.setInt(2, empno);
		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.execute();
		String dname = cs.getString(1);
		System.out.println("�μ���:"+dname);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   public void insert() {
   
      System.out.println("��� �Է� : ");
      int empNo = sc.nextInt();
      System.out.println("�̸� �Է� : ");
      String empName = sc.next();
      System.out.println("job �Է� : ");
      String empJob = sc.next();
      System.out.println("mgr �Է� : ");
      int empMgr = sc.nextInt();
      System.out.println("sal �Է� : ");
      int empSal = sc.nextInt();
      try {
         Connection con = DriverManager.getConnection(url, id, pwd);
         String sql ="{call INS(?,?,?,?,?)}";
         CallableStatement cs = con.prepareCall(sql);
         cs.setInt(1, empNo);
         cs.setString(2, empName);
         cs.setString(3, empJob);
         cs.setInt(4, empMgr);
         cs.setInt(5, empSal);
         cs.executeUpdate();
         
      } catch (SQLException e) {
         // TODO �ڵ� ������ catch ���
         e.printStackTrace();
      }
   }
   public void printAll() {
	   try {
		Connection con = DriverManager.getConnection(url, id, pwd);
		String sql ="{?=call funcSum()}";
		CallableStatement cs = con.prepareCall(sql);
		cs.registerOutParameter(1,OracleTypes.CURSOR);
		cs.executeQuery();
		ResultSet rs = (ResultSet)cs.getObject(1);
		while(rs.next()) {
			System.out.println("�μ���:"+ rs.getString(1));
			System.out.println("�����:"+ rs.getString("cnt"));
			System.out.println("�޿�:"+ rs.getInt("ssal"));
		}
	   } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
   }
   public static void main(String[] args) {
      InsertTest test = new InsertTest();
      //test.insert();
      //�μ� ��� �޿� ���ϴ� �Լ� 
      //�μ��� ����ϴ� �Լ�
      test.printAvg();
      test.printDname();
      test.printAll();
   }
}