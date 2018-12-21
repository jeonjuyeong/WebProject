<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script> 
	$(document).ready(function(){
		$("#btn").click(function(){
			$.post("process.jsp",
					{"id":$("#id").val(),"pwd":$("#pwd").val()},//내용을 배열에 담는다. key값과value값.
				function(data){//콜백함수
					alert(data);
					$("#result").html(data);
				});
		});
	});
</script>
</head>
<body>
<form>
id  :   <input type="text" id ="id" name ="id"><br>
pwd : <input type="password" id ="pwd" name ="pwd"><br>
<input type ="button" id="btn" value ="전송"><br><br>
<div id = "result"></div>
</form>
</body>
</html>