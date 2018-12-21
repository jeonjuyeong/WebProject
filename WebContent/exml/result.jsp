<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
String name =	request.getParameter("name");
String addr = request.getParameter("addr");
%>
<body>
	성공<hr>
	이름:  <% out.println(name); %> 	<br>
	주소:	 <% out.println(addr); %> 	<br>
</body>
</html>