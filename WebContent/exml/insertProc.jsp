<%@page import="com.jquery.AddressDAO"%>
<%@page import="com.jquery.AddressBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<%

   request.setCharacterEncoding("utf-8");
 
%>
<body>
<jsp:useBean id ="ab" class = "com.jquery.AddressBean"></jsp:useBean>
<jsp:setProperty property ="*" name="ab"/>
<% 	
 	AddressDAO dao  = AddressDAO.getInstance();
	dao.addressInsert(ab);
	response.sendRedirect("list.jsp");
%>
이름: <%=ab.getName() %><br>
주소: <%=ab.getAddr()%><br>
 폰: <%=ab.getPhone() %><br>

</body>
</html>