<%@page import="web.ScoreBean"%>
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
int kor = Integer.parseInt(request.getParameter("kor"));
int eng = Integer.parseInt(request.getParameter("eng"));
int math = Integer.parseInt(request.getParameter("math"));
ScoreBean sb = new ScoreBean();
sb.setName(name);
sb.setKor(kor);
sb.setEng(eng);
sb.setMath(math);

double avg=sb.getAvg(kor, eng,math);

%>
</head>
<body>
성공
<br>
	이름:<%=sb.getName() %> <br>
	국어:	<%=sb.setKor(kor) %> <br>
	영어:	 <%=sb.setEng(eng) %><br>
	수학:	 <%=sb.setMath(math) %><br>
	총점:  <%=sb.getTotal(kor, eng, math)%><br>
	평균:   <%= avg%><br>
	학점:  <%=sb.getGrade(avg)%><br>
</body>
</html>