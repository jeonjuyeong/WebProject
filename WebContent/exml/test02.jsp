<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String name =request.getParameter("name");
String status =request.getParameter("status");
String str="처리결과";
str+="name:<u>"+name+"</u><br>";
str+="status:<u>"+status+"</u><br>";
out.println(str);
%>