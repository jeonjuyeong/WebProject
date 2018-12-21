<%@page import="com.board.BoardBean"%>
<%@page import="com.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
$(document).ready(function(){});
</script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<style>  
	body { background: #fff; padding : 30px;}
	#blueone {
	  border-collapse: collapse;
	}  
	#blueone th {
	  padding: 10px;
	  color: #168;
	  border-bottom: 3px solid #FACC2E;
	  text-align: left;
	}
	#blueone td {
	  color: #669;
	  padding: 10px;
	  border-bottom: 1px solid #ddd;
	}
	
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	BoardDAO dao  = BoardDAO.getInstance();
	int num = Integer.parseInt(request.getParameter("num"));
	BoardBean b = dao.getBoard(num);
	int ref =b.getRef();
	int re_step=b.getRe_step();
	int re_level=b.getRe_level();
	
%>
</head>
<body>
<div class="col-xs-6">
<table id="blueone" class="table table-hover">
	<tr>
		<th colspan="3">
		<th>
	</tr>
	<tr>
		<td>글번호</td>
		<td><%=b.getNum()%></td>
		<td>조회수</td>
		<td><%=b.getReadcount()%></td>
	</tr>
	<tr>
		<td>작성자</td>
		<td><%=b.getWriter() %></td>
		<td>작성일</td>
		<td><%=b.getReg_date()%></td>
	</tr>
	<tr>
		<td>글제목</td>
		<td colspan=3><%=b.getSubject()%></td>
	</tr>
	<tr>
		<td>글내용</td>
		<td colspan=3><%=b.getContent()%></td>
	</tr>
	<tr>
		<th><input type = "button" class ="btn btn-default" value ="글수정" id="update" onclick="location='passwdCheck.jsp?num=<%=b.getNum()%>'"></th>
		<th><input type = "button" class ="btn btn-default" value ="글삭제" onclick="location = 'deleteForm.jsp?num=<%=b.getNum()%>'"></th>
		<th><input type = "button" class ="btn btn-default" value ="답글쓰기" id="dap" onclick ="location.href ='board.jsp?num=<%=b.getNum()%>&ref=<%=ref%>&re_step=<%=re_step %>&re_level=<%= re_level%>'"></th>
		<th><input type = "button"  class ="btn btn-default" value ="글목록" id="update" onclick="location.href='boadList.jsp'"></th>
	</tr>
</table>
</div>
</body>
</html>