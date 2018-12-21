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
	   System.out.println("부서번호:");
	   int deptno =sc.nextInt();
	   try {
		Connection con = DriverManager.getConnection(url, id, pwd);
	     String sql ="{?=call getAVG(?)}";
         CallableStatement cs = con.prepareCall(sql);
         cs.setInt(2, deptno);
         cs.registerOutParameter(1, java.sql.Types.INTEGER);
         cs.execute();
         int avg=cs.getInt(1);
         System.out.println("평균급여:"+avg);
	   } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   }
   }
   public void printDname() {
	   System.out.println("사원번호입력>>");
	   int empno =sc.nextInt();
	   try {
		Connection con = DriverManager.getConnection(url, id, pwd);
		String sql = "{?=call dname(?)}";
		CallableStatement cs = con.prepareCall(sql);
		cs.setInt(2, empno);
		cs.registerOutParameter(1, java.sql.Types.VARCHAR);
		cs.execute();
		String dname = cs.getString(1);
		System.out.println("부서명:"+dname);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   public void insert() {
   
      System.out.println("사번 입력 : ");
      int empNo = sc.nextInt();
      System.out.println("이름 입력 : ");
      String empName = sc.next();
      System.out.println("job 입력 : ");
      String empJob = sc.next();
      System.out.println("mgr 입력 : ");
      int empMgr = sc.nextInt();
      System.out.println("sal 입력 : ");
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
         // TODO 자동 생성된 catch 블록
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
			System.out.println("부서명:"+ rs.getString(1));
			System.out.println("사원수:"+ rs.getString("cnt"));
			System.out.println("급여:"+ rs.getInt("ssal"));
		}
	   } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
   }
   public static void main(String[] args) {
      InsertTest test = new InsertTest();
      //test.insert();
      //부서 평균 급여 구하는 함수 
      //부서명 출력하는 함수
      test.printAvg();
      test.printDname();
      test.printAll();
   }
}