package com.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	String url,id,pwd;
  private static BoardDAO instance=new BoardDAO();
  
  public static BoardDAO getInstance() {
	  return instance;
  }
	private Connection getConnection() throws Exception{
		Context initContext = new InitialContext();
		Context envContext = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/jsp");
		return ds.getConnection();
	}
	public BoardDAO() {
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
	//추가
	public int size(String field,String word) {
		Connection con =null;
		Statement st = null;
		ResultSet rs = null;
		String sql="";
		int cnt =0;
			try {
				con= getConnection();
				if(word.equals("")) {
					sql = "select count(*) from board";
				}else {
					sql="select count(*) from board where "+field+" like '%"+word+"%'";
					
				}
				System.out.println(sql);
				st = con.createStatement();
				rs = st.executeQuery(sql);
				if (rs.next()) {
					cnt=rs.getInt(1);
					System.out.println(cnt);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closeCon(con,st,rs);
			}
		return cnt;		
}
	

	public void boardInsert(BoardBean b) {
			Connection con= null;
			PreparedStatement ps =  null;
			ResultSet rs = null;
			int number=1;
			String sql="";
			try {
					con = getConnection();
					//부모글
					int num =b.getNum();
					int ref = b.getRef();
				
					int re_step = b.getRe_step();
					int re_level= b.getRe_level();
					ps=con.prepareStatement("select max(num) from board");
					rs=ps.executeQuery();
					if(rs.next()) {
						number =rs.getInt(1)+1;
					}
					//새글or답변글 구분
					if(num!=0) {//답변글
						sql="update board set re_step = re_step +1 where ref =? and re_step>?";
						ps=con.prepareStatement(sql);
						ps.setInt(1, ref);
						ps.setInt(2, re_step);
						ps.executeUpdate();
						re_step=re_step+1;
						re_level=re_level+1;
				
					}else {//새글
						ref=number;
						re_step=0;
						re_level=0;
					}

					sql = "insert into board (num,writer,email,passwd,reg_date,readcount,ref,re_step,re_level,content,subject,ip) values (board_seq.nextval,?,?,?,SYSDATE,0,?,?,?,?,?,?)";
					ps = con.prepareStatement(sql);
					ps.setString(1,b.getWriter());
					ps.setString(2, b.getEmail());
					ps.setString(3, b.getPasswd());
					ps.setInt(4, ref);
					ps.setInt(5, re_step);
					ps.setInt(6, re_level);
					ps.setString(7, b.getContent());
					ps.setString(8, b.getSubject());
					ps.setString(9, b.getIp());
					ps.executeUpdate();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					closeCon(con,ps);
				}
				
		}
	//수정하기
	public void boardUpdate(BoardBean b,int num) {
			Connection con= null;
			PreparedStatement ps =  null;
			ResultSet rs = null;
			try {
				    con = getConnection();
					String sql = "Update board set writer=?,Email=?,passwd=?,Content=?,Subject=? where num="+num;
					ps = con.prepareStatement(sql);
					ps.setString(1,b.getWriter());
					ps.setString(2, b.getEmail());
					ps.setString(3, b.getPasswd());
					ps.setString(4, b.getContent());
					ps.setString(5, b.getSubject());
					
					ps.executeUpdate();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					closeCon(con,ps);
				}
				
		}
	//전체보기
	public ArrayList<BoardBean> boardList(String field, String search,int startRow,int endRow) {
		ArrayList<BoardBean> arr =new ArrayList<BoardBean>();
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql="";
		BoardBean b=null;
			try {
				con = getConnection();
				if(field.equals("")) {
					sql = "select * from (select rownum rn,aa.* from (select * from board order by reg_date desc,re_step asc)aa) where rn>=? and rn<=?";
					}else {
						sql="select * from (select rownum rn,aa.* from (select * from board where "+field+" like '%"+search+"%' order by reg_date desc,re_step asc)aa) where rn>=? and rn<=?";
					
					}
				System.out.println(sql);
				ps = con.prepareStatement(sql);
				ps.setInt(1, startRow);
				ps.setInt(2, endRow);
				rs = ps.executeQuery();
				while (rs.next()) {
					b = new BoardBean();
					b.setNum(rs.getInt("num"));
					b.setSubject(rs.getString("subject"));
					b.setWriter(rs.getString("writer"));
					b.setReg_date(rs.getString("reg_date"));
					b.setReadcount(rs.getInt("readcount"));
					b.setIp(rs.getString("ip"));
					b.setReadcount(rs.getInt("readcount"));
					b.setRef(rs.getInt("ref"));
					b.setRe_step(rs.getInt("re_step"));
					b.setRe_level(rs.getInt("re_level"));
					arr.add(b);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closeCon(con,ps,rs);
			}
		return arr;
	}
	public String getPasswd(int num) {
		String passwd ="";
		Connection con =null;
		Statement st = null;
		ResultSet rs = null;
		String sql="";
		BoardBean b=null;
			try {
				con= getConnection();
				sql = "select passwd from board where num="+num;
				
				st = con.createStatement();
				rs = st.executeQuery(sql);
				if (rs.next()) {
					passwd=rs.getString(1);
					System.out.println(passwd);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closeCon(con,st,rs);
			}
		return passwd;
	}
	public void boardDelete(int num) {

		Connection con= null;
		PreparedStatement ps =  null;
			try {
				con = getConnection();
				String sql = "delete from board where num ="+num;
				System.out.println(sql);
				ps = con.prepareStatement(sql);
				ps.executeUpdate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closeCon(con,ps);
			}
			
	}
	
	public BoardBean getBoard(int num) {
		
		Connection con =null;
		Statement st = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		String sql="";
		int cnt =0;
		BoardBean b=null;
			try {
				con= getConnection();
				sql = "select * from board where num ="+num;
				System.out.println(sql);
				st = con.createStatement();
				rs = st.executeQuery(sql);
				if (rs.next()) {
						b = new BoardBean();
						b.setNum(rs.getInt("num"));
						b.setSubject(rs.getString("subject"));
						b.setWriter(rs.getString("writer"));
						b.setEmail(rs.getString("email"));
						b.setReg_date(rs.getString("reg_date"));
						b.setReadcount(rs.getInt("readcount"));
						b.setContent(rs.getString("content"));
						b.setReadcount(rs.getInt("readcount"));
						b.setRef(rs.getInt("ref"));
						b.setRe_step(rs.getInt("re_step"));
						b.setRe_level(rs.getInt("re_level"));
						
				}
				sql="update board set readcount="+(rs.getInt("readcount")+1)+"where num="+num;
				ps = con.prepareStatement(sql);
				ps.executeUpdate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				closeCon(con,st,rs);
			}
		return b;		
	}
private void closeCon(Connection con, PreparedStatement ps){
		
		try {
			if(con!=null)con.close();
			if(ps!=null)ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
private void closeCon(Connection con,Statement st, ResultSet rs){
	
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
