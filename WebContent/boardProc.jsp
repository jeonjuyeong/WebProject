<%@page import="com.board.BoardBean"%>
<%@page import="com.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title herdwdw</title>
</head>
<body>
<%
   request.setCharacterEncoding("utf-8");
%>
<body>
<jsp:useBean id ="b" class = "com.board.BoardBean"></jsp:useBean>
<jsp:setProperty property ="*" name="b"/>
<%
	BoardDAO dao  = BoardDAO.getInstance();
  	b.setIp(request.getRemoteAddr());//클라이언트 ip주소를 구해줌
	dao.boardInsert(b);
	   response.sendRedirect("boadList.jsp");
%>
</body>
</html>