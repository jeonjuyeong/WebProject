<%@page import="web.DateBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%	
	DateBean bean= new DateBean();

%>
</head>
<body>
오늘 날짜/요일:<%= bean.getToday() %>
</body>
</html>