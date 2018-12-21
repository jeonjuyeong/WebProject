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
		$("#btn").click(function(){//$.get/$.post/$.load/$.ajax
			$("#result").load("jquery.jsp",function(data,stu){//stu는 성공이면 success자동으로 뜬다.
				if(stu=="success"){
					alert(data)
					$("#result").html(data);
					}else{
					alert("실패")
				}
			});
		});
	});
</script>
</head>
<body>
<button id ="btn">결과</button><br><br>
<div id ="result"></div>
</body>
</html>