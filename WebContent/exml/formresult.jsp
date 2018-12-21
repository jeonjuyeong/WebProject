
<%@page import="web.FormBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
   request.setCharacterEncoding("utf-8");
  %>
	<jsp:useBean id ="fb" class ="web.FormBean"></jsp:useBean>
	<jsp:setProperty property="*" name="fb"/>
  <%
   String tmp ="";
   String []h=request.getParameterValues("hobby");
   for(int i=0; i<h.length;i++){
      tmp += h[i] +" ";}
%>
</head>
<body>
 이름: <jsp:getProperty property="name" name="fb"/><br>
 나이:  <jsp:getProperty property="age" name="fb"/><br>
 성별:  <jsp:getProperty property="gender" name="fb"/><br>
 취미: <%=tmp%><br>
 직업:  <jsp:getProperty property="job" name="fb"/><br>
 자기소개: <jsp:getProperty property="memo" name="fb"/><br>
</body>
</html>