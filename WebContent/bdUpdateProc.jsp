<%@page import="com.board.BoardBean"%>
<%@page import="com.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
   request.setCharacterEncoding("utf-8");
	%>
    <jsp:useBean id ="b" class = "com.board.BoardBean"></jsp:useBean>
<jsp:setProperty property ="*" name="b"/>
<% 
	
	BoardDAO dao  = BoardDAO.getInstance();
	int num = Integer.parseInt(request.getParameter("num"));
	dao.boardUpdate(b,num);
	response.sendRedirect("boadList.jsp");
%>