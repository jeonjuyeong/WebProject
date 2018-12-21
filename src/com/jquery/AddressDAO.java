package com.jquery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class AddressDAO {
	private static AddressDAO instance = new AddressDAO();
	ArrayList<AddressBean> arr ;
	public static AddressDAO getInstance(){
		return instance;
	}
	
	private Connection getConnection() throws Exception{
		Context initContext = new InitialContext();
		Context envContext = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/jsp");
		return ds.getConnection();
	}
	
	public void addressInsert(AddressBean ab) {
		Connection con= null;
		PreparedStatement ps =  null;
		
			try {
				con = getConnection();
				String sql = "Insert into addr values (addr_seq.nextval,?,?,?)";
				ps = con.prepareStatement(sql);
				ps.setString(1,ab.getName());
				ps.setString(2, ab.getAddr());
				ps.setString(3, ab.getPhone());
				ps.executeUpdate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closeCon(con,ps);
			}
			
	}
	public void addressDelete(AddressBean ab) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConnection();
			String sql = "Delete from addr where num=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, ab.getNum());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeCon(con,ps);
		}
	}
	public void addressUpdate(AddressBean ab) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConnection();
			String sql = "Update addr set name=?,addr=?,phone=? where num=?";
			ps = con.prepareStatement(sql);
			ps.setString(1,ab.getName());
			ps.setString(2, ab.getAddr());
			ps.setString(3, ab.getPhone());
			ps.setInt(4, ab.getNum());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeCon(con,ps);
		}
	
	}
	public ArrayList<AddressBean> addressList(){
		Connection con = null;
		Statement st = null;
		ResultSet rs =null;
		arr = new ArrayList<>();
		try {
			con = getConnection();
			st = con.createStatement();
			String sql = "select * from addr";
			rs = st.executeQuery(sql);
			while (rs.next()) {
				AddressBean ab = new AddressBean();
				ab.setNum(rs.getInt("num"));
				ab.setName(rs.getString("name"));
				ab.setAddr(rs.getString("addr"));
				ab.setPhone(rs.getString("phone"));
				arr.add(ab);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeCon(con, st,rs);
		}
		return arr;

	}
	public int addressCount() {
		return arr.size();
	}
	public AddressBean addressView(int num) {
		Connection con =null;
		Statement st = null;
		ResultSet rs = null;
		AddressBean ab=null;
			try {
				con = getConnection();
				st = con.createStatement();
				String sql = "select * from addr where num="+num;
				rs = st.executeQuery(sql);
				if(rs.next()) {
					ab = new AddressBean();
					ab.setNum(rs.getInt("num"));
					ab.setName(rs.getString("name"));
					ab.setAddr(rs.getString("addr"));
					ab.setPhone(rs.getString("phone"));
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closeCon(con, st,rs);
			}
			return ab;
		}
	private void closeCon(Connection con, PreparedStatement ps) {
		
			try {
				if(con!=null)con.close();
				if(ps!=null)ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	private void closeCon(Connection con,Statement st, ResultSet rs) {
		
		try {
			if(con!=null)con.close();
			if(st!=null)st.close();
			if(rs!=null)rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
}
