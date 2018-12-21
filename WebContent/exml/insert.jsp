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
       if($("#name").val()==""){
          alert("이름 입력");
          return false;
       }
       if($("#age").val()==""){
          alert("나이 입력");
          return false;
       }
       if($("input[type=radio]:checked").length==0){
          alert("성별 선택");
          return false;
       }
       if($("#memo").val()==""){
          alert("자기소개 입력");
          return false;
       }
       $("#frm").submit();
    });
 });

$(function(){
		$("#btnZip").click(function(){
			window.open("zipCheckjsp.jsp","","width=500 height =500");
		})	
	});
</script> 
</head>
<body>
우편번호 : <input type ="text" name="zipcode" id="zipcode" size=15>
<input type="button" value ="검색" id ="btnZip"><br>
주소 : <input type ="text" name="addr" id="addr" size="50">
</body> 
</html>