<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
request.setCharacterEncoding("utf-8");
String name =	request.getParameter("name");
int korean = Integer.parseInt(request.getParameter("korean"));
int english = Integer.parseInt(request.getParameter("english"));
int math = Integer.parseInt(request.getParameter("math"));
int total = korean+english+math;
int avg =total/3;
String grade="";
if(avg>90){
	grade="A";
}else if(avg>80){
	grade="B";
}else if(avg>70){
	grade="C";
}else{
	grade="F";
}
%>
</head>
<body>
성공
<br>
	이름:  <%=name %> 	<br>
	국어:	 <%=korean %> 	<br>
	영어:	 <%=english %> 	<br>
	수학:	 <%=math %> 	<br>
	총점: <%=total %> <br>
	평균: <%=avg %> <br>
	학점: <%=grade %> <br>
</body>
</html>