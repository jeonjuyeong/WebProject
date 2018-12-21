package com.jquery;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ZipCodeDBA{

	private static ZipCodeDBA instance = new ZipCodeDBA();
	
	public static ZipCodeDBA getInstance(){
		return instance;
	}
	public Connection getConnection() throws Exception{
		Context initCtx =new InitialContext();
		Context envCtx = (Context)initCtx.lookup("java:comp/env");
		DataSource ds =(DataSource)envCtx.lookup("jdbc/jsp");
		return ds.getConnection();
	}
		
	//우편번호 검색 하기 
	public ArrayList<ZipCode> zipSearch(String dong) {
		ArrayList<ZipCode> arr = new ArrayList<>();
		  Connection con = null;
	      Statement st = null;
	      ResultSet rs = null;
	  
	      try {
	    	 con = getConnection();
	         String sql = "select * from zipcode where dong like '%"+dong+"%'";
	         st = con.createStatement();
	         rs = st.executeQuery(sql);
	         while(rs.next()) {
	        	 ZipCode z = new ZipCode();
	        	 z.setZipcode(rs.getString("zipcode"));
	        	 z.setSido(rs.getString("sido"));
	        	 z.setGugun(rs.getString("gugun"));
	        	 z.setDong(rs.getString("dong"));
	        	 z.setBunji(rs.getString("bunji"));
	      
	        	 
	        	 arr.add(z);
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
	         try {
	            if(rs!=null)rs.close();
	            if(st!=null) st.close();
	            if(con!=null) con.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
		
		return arr;
	}
}
