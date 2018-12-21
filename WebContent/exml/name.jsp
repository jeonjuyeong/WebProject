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
  
   String tmp ="";
   String []h=request.getParameterValues("hobby");
   for(int i=0; i<h.length;i++){
      tmp += h[i] +" ";}
    
	FormBean fb=new FormBean();
	
	String name =request.getParameter("name");
	int age=Integer.parseInt(request.getParameter("age"));
	String gender=request.getParameter("gender");
	String job=request.getParameter("job");
	String memo =request.getParameter("memo");
   fb.setName(name);
   fb.setAge(age);
   fb.setGender(gender);
   fb.setHobby(request.getParameterValues("hobby"));
   fb.setJob(job);
   fb.setMemo(memo);
%>
</head>
<body>
 이름: <%=fb.getName() %><br>
 나이: <%=fb.getAge()%><br>
 성별: <%=fb.getGender() %><br>
 취미: <%=tmp%><br>
 직업: <%=fb.getJob()%><br>
 자기소개: <%=fb.getMemo() %><br>
</body>
</html>