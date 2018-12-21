<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	$(document).ready(function(){
	    $("#btn").click(function(){
	     	if($("#name").val()==""){
	     		alert("이름을 입력하세요.")
	     		return false;
	     	}
	     	if($("#addr").val()==""){
	     		alert("이름을 입력하세요.")
	     		return false;
	     	}
	     	$("#form").submit();
	    });//btn 
	});//document
</script>
<body>

	<form id="form" action ="result.jsp" >
		이름: <input type='text' name='name' id="name">
		<br>
		주소: <input type ='text' name='addr' id="addr">
		<br>
		<input type='button' id="btn" value='전송' > <input type='reset' value='취소'>
	</form>
</body>
</html>