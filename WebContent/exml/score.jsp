<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>

	function check(){
		if(frm.name.value==""){
			alert("이름 입력 필요");
			return;
		}
		else if(frm.kor.value==""){
			alert("국어 점수 입력 필요");
			return;
		}
		else if(frm.math.value==""){
			alert("수학 점수 입력 필요");
			return;
		}
		else if(frm.eng.value==""){
			alert("영어 점수 입력 필요");
			return;
		}
		frm.submit();
	}
</script>
</head>
<body>
	<form action="scoreresult3.jsp" name="frm"  method="post">
		이름 : <input type="text" id="name" name="name"><br>
		국어 : <input type="text" id="kor" name="kor"><br>
		수학 : <input type="text" id ="math" name="math"><br>
		영어 : <input type="text" id="eng" name="eng"><br>
		<input type="button" value="성적조회" onclick="check()">
		<input type="reset" value="취소">
	</form>
</body>
</html>