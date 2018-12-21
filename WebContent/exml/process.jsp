<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");
String str="처리결과 :<br>";
str+="아이디:"+id+"<br>";
str+="비번:"+pwd;
out.println(str);
%>
