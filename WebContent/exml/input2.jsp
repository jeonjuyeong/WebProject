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
		if(form.name.value==""){
			alert("이름을 입력하세요");	
			return;
		}
		if(form.addr.value==""){
			alert("주소를 입력하세요");
			return;
		}
		form.submit();
	}
</script>

<body>
	<form name="form" action ="result.jsp" onsubmit="return check()">
		이름: <input type='text' name='name'>
		<br>
		주소: <input type ='text' name='addr'>
		<br>
		<input type='submit' value='전송' onclick="check()"> <input type='reset' value='취소'>
	</form>
</body>
</html>