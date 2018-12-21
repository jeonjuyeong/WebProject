<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
$(document).ready(function(){
    $("#btn").click(function(){
       if($("#name").val()==""){
          alert("이름 입력");
          return false;
       }
       if($("#addr").val()==""){
          alert("주소입력");
          return false;
       }
       if($("#phone").val()==""){
          alert("전화번호입력");
          return false;
       }
       $("#frm").submit();
    });
 });

</script>
<body>
<form action="insertProc.jsp" id="frm">
<table border="1">
<tr>
	<td bgcolor="Brown"colspan=2 align ="center">
		주소록 등록하기
	</td>
</tr>
<tr>
	<td>
		이름
	</td>
	<td>
		<input type="text" id = "name"  width="20" name="name">
	</td>
</tr>
<tr>
	<td>
		주소
	</td>
	<td>
		<input type="text" id = "addr" width="40" name ="addr">
	</td>
</tr>
<tr>
		<td>
		전화번호
	</td>
	<td>
		<input type="text"  id = "phone" width="30" name ="phone">
	</td>
</tr>
<tr>
	<td colspan=2 align ="center">
		<input type="button" id ="btn" value="등록" >	
		<input type="reset"  value="취소" >
	</td>
</tr>
</table>
</form>
</body>
</html>