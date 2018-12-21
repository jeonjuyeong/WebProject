<%@page import="com.jquery.AddressBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.jquery.AddressDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	AddressDAO dao = AddressDAO.getInstance();
	ArrayList<AddressBean> arr = dao.addressList();
	int count = dao.addressCount();
%>
<div align ="left"> 총 수: <%=count %></div>
<a href = "insert1.jsp">등록하기 </a>
<table border ="1">
	<tr>
		<td>번호</td>
		<td>이름</td>
		<td>주소</td>
		<td>전화번호</td>
	</tr>
	<% 
	 for(int i =0; i <arr.size(); i ++){
		 %>
		 <tr>
		 	<td><%=arr.get(i).getNum() %></td>
		 	<td><a href="addrView.jsp?num=<%=arr.get(i).getNum()%>"><%=arr.get(i).getName() %></a></td>
		 	<td><%=arr.get(i).getAddr() %></td>
		 	<td><%=arr.get(i).getPhone() %></td>
		 </tr>
		 <%
	 }
		%>
</table>
</body>
</html>