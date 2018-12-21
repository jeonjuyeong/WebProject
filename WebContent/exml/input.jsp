<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>

	function check(){
	
		if(document.getElementById.value==""){
			alert("이름을 적어주세요");
			return;
		}
		if(document.getElementById.value==""){
			alert("주소를 적어주세요");
			return;
		}
		document.getElementById("form").submit();
	}
</script>

<body>
	<form id="form" action ="result.jsp">
		이름: <input type='text' name='name' id ="name">
		<br>
		주소: <input type ='text' name='addr' id="addr">
		<br>
		<input type='button' value='전송' onclick="check()"> <input type='reset' value='취소'>
	</form>
</body>
</html>