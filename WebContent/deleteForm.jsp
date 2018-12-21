<%@page import="com.board.BoardBean"%>
<%@page import="com.board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 삭제</title>
</head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<style>  
	body { background: #fff; padding : 150px;}
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

<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>

<%
	BoardDAO dao  = BoardDAO.getInstance();
	int num = Integer.parseInt(request.getParameter("num"));
%>
<script>
$(document).ready(function(){
	
})
	if(passwd==$("#passwd").val()){
	dao.boardDelete(num);}
	else{
		
	};
</script>
</head>
<body>
<div class="col-xs-7">
<form action= "deleteProc.jsp?num=<%=num%>" method ="post">
	<table id="blueone" class="table table-hover">
		<tr>
			<th>
			</th>
		</tr>
		<tr>
			<td>글삭제</td>
		</tr>
		<tr>
			<td>비밀번호 입력:<input type="password"  class="form-control" id= "passwd" name ="passwd"></td>
		</tr>
		<tr>
			<td><input type = "submit" class ="btn btn-default" value ="삭제">
			<input type = "button" class ="btn btn-default" value ="글목록" onclick="location='boadList.jsp'"></td>		
		</tr>
	</table>
	</form>
</div>
</body>
</html>