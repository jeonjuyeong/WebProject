<%@page import="com.member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
 request.setCharacterEncoding("utf-8");
String id = request.getParameter("userid");

	MemberDAO dao  = MemberDAO.getInstance();	
	String check= 	dao.idcheck(id);
	out.println(check);	
%>